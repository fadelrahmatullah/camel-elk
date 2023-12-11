package com.camel.mq.elk.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_company")
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="dpt_id", nullable=false)
    private Department departmentCode;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_desc")
    private String companyDesc;


    public Company(Department departmentCode, String companyName, String companyDesc) {
        this.departmentCode = departmentCode;
        this.companyName = companyName;
        this.companyDesc = companyDesc;
        this.setCreatedBy("Admin");
        this.setCreatedDt(new Date());
    }

    
}
