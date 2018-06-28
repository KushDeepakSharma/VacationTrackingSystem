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
public class LeaveRequest {
     private String userid,start,managerid,end;
     long days;
 public LeaveRequest(String userid,String start,String end,long days)
 {
 this.userid=userid;
 this.start=start;
 this.end=end;
 this.managerid=managerid;
 this.days=days;
 }
 public String getuserid(){
     return userid;
 }
 public String getstart(){
     return start;
 }
 public String getend(){
     return end;
 }
 public String getmanagerid(){
     return managerid;
 }
  public long getdays(){
     return days;
 }
}
