create TABLE users(
 u_id IDENTITY PRIMARY key,
 u_name VARCHAR(65) UNIQUE,
 u_password VARCHAR(200),
 u_email VARCHAR(200) ,
 u_image_url VARCHAR(200)
);