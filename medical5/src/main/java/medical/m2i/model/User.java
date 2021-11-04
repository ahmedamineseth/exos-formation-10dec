package medical.m2i.model;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name="User.findByUsernameAndPassword",
                query="SELECT u FROM User u WHERE u.username = :username AND u.password = md5( :password )"),
}) 
public class User {
    private int id;
    private String username;
    private String email;
    private String roles;
    private String password;
    private String name;
    private String photouser;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 180)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "roles", nullable = false, length = -1)
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "photouser", nullable = true, length = 500)
    public String getPhotouser() {
        return photouser;
    }

    public void setPhotouser(String photouser) {
        this.photouser = photouser;
    }

}
