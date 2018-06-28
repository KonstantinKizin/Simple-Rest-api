package by.kizin.konstantin.resttask.service;

import by.kizin.konstantin.resttask.entity.UserStatus;

public class UpdateUserStatusResult {

    private Long userId;

    private UserStatus oldStatus;

    private UserStatus newStatus;

    public UpdateUserStatusResult(Long userId, UserStatus oldStatus, UserStatus newStatus) {
        this.userId = userId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(UserStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public UserStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(UserStatus newStatus) {
        this.newStatus = newStatus;
    }


    @Override
    public String toString() {
        return "UpdateUserStatusResult{" +
                "userId=" + userId +
                ", oldStatus=" + oldStatus +
                ", newStatus=" + newStatus +
                '}';
    }
}
