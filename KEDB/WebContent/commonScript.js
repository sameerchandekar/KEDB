

function validdate(create,close)
{
	//alert("create date is:"+create+"close date is :"+close);
	var year1=null;
	var year2=null;
	var month1=null;
	var month2=null;
	var day1=null;
	var day2=null;
	month1=create.substring(0,1);
	day1=create.substring(3,4);
	year1=create.substring(6,9);

	month2=close.substring(0,1);
	day2=close.substring(3,4);
	year2=close.substring(6,9);
	
	if(year2>=year1)
		{
		
		if(month2>=month1)
			{
						if(day2>=day1)
							{
							return true;
							}
						else
							{return false;}
			}
		else
			{
			return false;
			}
		
		}
	else
	{
	return false;	
	}
			
	
	
	
}
 function addIncidentValidate()
 {

	 var flag=null;
	 var a= document.getElementById("IN").value;
	 var b= document.getElementById("IT").value;
	 var c= document.getElementById("ID").value;
	 var d= document.getElementById("PN").value;
	 var e= document.getElementById("WA").value;
	 var f= document.getElementById("CC").value;
	 var g= document.getElementById("datepicker").value;
	 var h= document.getElementById("datepicker1").value;
	 
	 if(a==null || a=="" || b==null || b=="" || c==null || c==""|| d==null || d==""|| e==null || e==""|| f==null || f==""|| f=="select"|| g==null || g==""|| h==null || h=="")
	 {
		 alert('Fields cannot be left blank');
		 return false;
	 }
	
	 else
		 {
		 flag =validdate(g,h); 
		 if(flag==false)
			 
			 {
			 alert("create date has to be less then close date");
			 return false;
			 }
     
		 }
	 if(flag==true)
		 {
	 return true;
		 }
	 else
		 {
		 return false;
		 }
 }
 
 
 function addProblemValidate()
 {

	 var a= document.getElementById("PN").value;
	 var b= document.getElementById("PT").value;
	 var c= document.getElementById("PD").value;
	 var d= document.getElementById("RCA").value;
	 var e= document.getElementById("PR").value;
	 var h= document.getElementById("datepicker").value;
	 
	 if(a==null || a=="" || b==null || b=="" || c==null || c==""|| d==null || d==""|| e==null || e=="" || h==null || h=="")
	 {
		 alert('Fields cannot be left blank');
		 return false;
	 }
	 
	 else
		 {
     return true;
		 }
	 
	 function delIncidentValidate()
	 {
		 
		 alert("Ensure before deleting as this is a permanent delete. You can't revert back.");
	 }
	 
	 function delProblemValidate()
	 {
		 
		 alert("Ensure before deleting as this is a permanent delete. You can't revert back.");
	 }
	 	 
 }

 function RegisterValidation() {
	 
	 
	 
	 var a= document.getElementById("username").value;
	 var b= document.getElementById("pwd").value;
	 var c= document.getElementById("cpwd").value;
	 var d= document.getElementById("isAdmin").value;
	 var e= document.getElementById("isSpoc").value;
	 
	
	 
	if(a==null || a=="" || b==null || b=="" || c==null || c=="")
	 {
		 alert('Fields cannot be left blank');
		 return false;
	 }
	 
	 else if(b!=c)
			 {
			 alert('Password and confirm password should be same');
			 return false;
			 }
		 
	 else
		 {
		 return true;
	
		 }
	
	
	
	
	 
	 	

	 }
 
 

 
 function confirmation()
 {
	 var retVal = confirm("Data will be deleted permanently!! Are you sure, enough???"); 
	if( retVal == true ){
	     
		  return true;
	   }else{
	     
		  return false;
	   }

	 
 }

 