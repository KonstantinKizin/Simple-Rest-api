package by.kizin.konstantin.resttask.entity;

import by.kizin.konstantin.resttask.entity.constant.UserColumnName;
import by.kizin.konstantin.resttask.entity.constant.ValidationMessage;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = UserColumnName.ID)
    private Long id;

    @Column(name = UserColumnName.NAME)
    @NotNull
    @Size(min = 3,max = 12,message = ValidationMessage.USER_NAME_SIZE)
    private String name;

    @Column(name = UserColumnName.IMAGE_URL)
    @Size(min = 2, message = ValidationMessage.USER_IMAGE_URL_SIZE)
    private String imageUrl;

    @Column(name = UserColumnName.EMAIL)
    @NotNull
    @Size(min = 5, message = ValidationMessage.USER_EMAIL_PATTERN)
    @Email(message = ValidationMessage.USER_EMAIL_SIZE)
    private String email;

    @Column(name = UserColumnName.PASSWORD)
    @NotNull
    @Size(min = 3, message = ValidationMessage.USER_PASSWORD_SIZE)
    private String password;

    private UserStatus status;


    public User(){}

    public User(String name, String imageUrl, String email, UserStatus status, String password) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.email = email;
        this.status = status;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
