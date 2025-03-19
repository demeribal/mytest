package login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "USERNAME", length = 12)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ROLE", nullable = false)
    private String role;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "REGDATE")
    private java.util.Date regdate;

    // 기본 생성자
    public Member() {}

    // getter/setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.util.Date getRegdate() {
        return regdate;
    }

    public void setRegdate(java.util.Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}


/*
drop table member;
create table member(
username varchar2(12) primary key,
password varchar2(12) not null,
email varchar2(50),
role varchar2(10) not null,
regdate date
);

insert into member 
values('user1','1234','user1@mysite.com','ROLE_USER',sysdate);

commit;

insert into member 
values('root','root','root@mysite.com','ROLE_ROOT',sysdate);

insert into member 
values('admin','admin','admin@mysite.com','ROLE_ADMIN',sysdate);

insert into member 
values('guest','guest','guest@mysite.com','ROLE_GUEST',sysdate);

*/
