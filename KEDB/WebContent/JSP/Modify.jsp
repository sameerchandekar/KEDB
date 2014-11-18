<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Quick-Fix:Known Error Database System</title>
<LINK href="../CSS/homepage.css" rel="stylesheet" type="text/css">
<LINK href="../CSS/Modify.css" rel="stylesheet" type="text/css">


<style type="text/css">
#one {
position:relative;
top:5%;
left:10%;   
    margin: 1px;

    
}
#two {
position:relative;
top:5%;
right:30%;
        margin: 1px;
 
    
}
</style>




<script type="text/javascript">

function ValidateForm(form){

	
	var number=document.getElementById("num").value;

if ( ( form.choice[0].checked == false ) && ( form.choice[1].checked == false ) ) 
{
alert ( "Please choose your either: INC or PRB" ); 
return false;
}


if(form.choice[0].checked == true)
	{
	window.open("/KEDB/JSP/ModifyIncident.jsp?number="+number+"", "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=500, left=500, width=600, height=600");
	//alert("/KEDB/JSP/inc.jsp?number="+number+"");
	}


if(form.choice[1].checked == true)
{
myWindow2 = window.open("/KEDB/JSP/ModifyProblem.jsp?number="+number+"", "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=500, left=500, width=600, height=600");
//alert("/KEDB/JSP/prb.jsp?number="+number+"");
}


//document.myform.submit();
	
	
}



</script>
</head>
<body style="background-color:#dae5f4;">
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%
try
{
	 if(session.getAttribute("uname").equals(null))
	{
		
		out.print("session value..."+session);
		} 

}
catch(NullPointerException e)
{
	response.sendRedirect("/KEDB/JSP/Login.jsp");
}

%>

 <div id="strip">
<%@ include file="Header.jsp" %> 
  
  </div>
  
        <div id="main_body" style="background-image: none;">
        
<div id="modify_left">


<!--  onsubmit="return validate();" -->
<form name="myform" method=post>
<div id="one">
<input type="radio" name="choice" value="inc" class="form_styles1"><span class="form_label1">Incident</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<input type="radio" name="choice" value="prob" class="form_styles1" ><span class="form_label1">Problem</span><br>
<br>
<span class="form_label1">Number:</span><input type="text" name="num" id="num" class="form_styles1" ><br>
<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;<input id="submit_1" type="button" name="SubmitButton" value="Submit" onClick="ValidateForm(this.form)"> 

</div>


</form>


</div> <!--  Left div end" -->
<div style="color:black; font-size:xx-large; font-family: calibiri; position: absolute;left:38%;top:25% ; font-weight: 900;">..or..</div>
        <div id="modify_right">
        
     <%@ include file="Search2Include.jsp" %> 

        
        </div>






</div>
 
<div id="footer">&copy; Developed by KEDB Development Team at Old Amex,DLF Chennai.
  <span style="float: right;">
  <%
	//for counter
  Operations opCount=new Operations();
  int counter=opCount.getCounter();
 %>
  
  Counter is:<%=counter%>
  
 
  </span>
  </div>


</body>
</html>