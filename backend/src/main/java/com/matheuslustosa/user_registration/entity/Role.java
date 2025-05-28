package com.matheuslustosa.user_registration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_role")
public class Role {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    private String name;


    enum typeRole{

        ADMIN(1),
        USER(2);

        private long roleID;

        typeRole(long id) {
            this.roleID = id;
        }

        public long getRoleID() {
            return this.roleID;
        }

    }






}
