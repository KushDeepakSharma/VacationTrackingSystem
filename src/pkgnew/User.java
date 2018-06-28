/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

/**
 *
 * @author Kush
 */
class User {
 private String userid,name,password,managerid,dateofj;
 public User(String name,String userid,String password,String managerid,String dateofj)
 {
 this.name=name;
 this.userid=userid;
 this.password=password;
 this.managerid=managerid;
 this.dateofj=dateofj;
 }
 public User(String name,String userid,String dateofj)
 {
 this.name=name;
 this.userid=userid;
 this.dateofj=dateofj;
 }
 public String getuserid(){
     return userid;
 }
 public String getname(){
     return name;
 }
 public String getpassword(){
     return password;
 }
 public String getmanagerid(){
     return managerid;
 }
  public String getdateofj(){
     return dateofj;
 }
 }
