package com.atahani.retrofit_sample.models;

/**
 * User Model
 */
public class UserModel {
    public String Id;
    public String UserName;
    //public List<RoleModel> Roles;
    public int Salary;
    public int FinalSalary;
    public int AbsentDays;
    public int OverTime;
    public int Benefits;

    public String getTitle(){
        return this.UserName;
    }

}
