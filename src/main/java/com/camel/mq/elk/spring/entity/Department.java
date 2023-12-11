package com.camel.mq.elk.spring.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_department")
public class Department extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "dpt_code")
    private String departmentCode;
    @Column(name = "dpt_name")
    private String departmentName;
    @Column(name = "dpt_desc")
    private String departmentDesc;
    @Column(name = "dpt_address")
    private String departmentAddress;

    @OneToMany(mappedBy="departmentCode")
    private List<Company> company;

    public Department(String departmentCode, String departmentName, String departmentDesc, String departmentAddress) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.departmentDesc = departmentDesc;
        this.departmentAddress = departmentAddress;
        this.setCreatedBy("Admin");
        this.setCreatedDt(new Date());
    }

    public Department(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    

}
