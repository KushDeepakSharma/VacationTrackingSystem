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
public class Leaves {
   private String userid,name,managerid,start,end,status;
   int days,yearol;
 public Leaves(String name,String userid,String managerid,String start,String end,int days,int yearol,String status)
 {
 this.name=name;
 this.userid=userid;
 this.managerid=managerid;
 this.start=start;
 this.end=end;
 this.days=days;
 this.yearol=yearol;
 this.status=status;
 }
 public String getuserid(){
     return userid;
 }
 public String getname(){
     return name;
 }
 public String getmanagerid(){
     return managerid;
 }
  public String getstart(){
     return start;
 }
  public String getend(){
     return end;
 }
 public String getstatus(){
     return status;
 }
 public int getdays(){
     return days;
 }
  public int getyearol(){
     return yearol;
 }
 }
