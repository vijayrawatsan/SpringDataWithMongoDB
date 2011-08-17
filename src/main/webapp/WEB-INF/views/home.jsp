<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Demo WebApp</title>
<link rel="stylesheet" type="text/css" href="resources/css/view.css" media="all"/>
<script type="text/javascript" src="resources/js/view.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>


</head>
<body id="main_body" >
	
	<img id="top" src="resources/images/top.png" alt=""/>
	<div id="form_container">
	
		<h1><a>Demo WebApp</a></h1>
		<div class="form_description">
			<h2>Demo WebApp</h2>
			<p>This webapp demonstrates Spring MVC + Spring Data + MongoDB integration.</p>
		</div>			
		
		<div id="">
			
		</div>
		<!-- <form id="form_229979" class="appnitro"  method="post" action="">
					<div class="form_description">
			<h2>Demo WebApp</h2>
			<p>This webapp demonstrates Spring MVC + Spring Data + MongoDB integration.</p>
		</div>						
			<ul >
			
					<li id="li_2" >
		<label class="description" for="element_2">Comment </label>
		<div>
			<textarea id="element_2" name="element_2" class="element textarea medium"></textarea> 
		</div><p class="guidelines" id="guide_2"><small>Add Comments here...
</small></p> 
		</li>
			
					<li class="buttons">
			    <input type="hidden" name="form_id" value="229979" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
		</li>
			</ul>
		</form>	 -->
		<div id="footer">
			Demo WebApp
		</div>
	</div>
	<img id="bottom" src="resources/images/bottom.png" alt=""/>
	<script type="text/javascript">
		$(document).ready(function() {
			/* $.getJSON("/posts", { name: "John", time: "2pm" }, function(json) {
			    alert("JSON Data: " + json.users[3].name);
			    }); */
			
			 
		 
		 $.post("http://localhost:8080/mongodb/comments/post", {
				"post" : {
					"id" : "70c8c480-6135-4e8a-9cc0-f2f08560e11b",
					"subject" : "post ka subject",
					"content" : "content of post",
					"user" : {
						"id" : "asdasdas",
						"userName" : "vijay",
						"password" : "pass"
					}
				}
			}
			, function(json) {
				alert("JSON Data: " + json[0]);
			}, "json"); 

			/* $.ajax({
				  type: 'POST',
				  url: "http://localhost:8080/mongodb/comments/post",
				  contentType : "application/json",
				  data: 
					{
						"post" : {
							"id" : "70c8c480-6135-4e8a-9cc0-f2f08560e11b",
							"subject" : "post ka subject",
							"content" : "content of post",
							"user" : {
								"id" : "asdasdas",
								"userName" : "vijay",
								"password" : "pass"
							}
						}
					},
				success : function(json) {
					alert("JSON Data: " + json[0].user.userName);
				}
			}); */
		});
	</script>
	</body>
</html>
