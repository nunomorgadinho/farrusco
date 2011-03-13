<script type="text/javascript">

  onload = function(){ alert('ola tudo bem');
	  field = document.getElementById('control_field')
	  field.onkeydown = keyhit
	  field.focus()
  }
  
  function doSomething(){
	  alert('something');
  }
  
  function keyhit(e)
  {
	  thisKey = e ? e.which : window.event.keyCode
	
	alert(thisKey);
			  
	  switch (thisKey) {
	  	case 38: key = 'UP'
	  	break
	  	case 40: key = 'DOWN'
	  	break
	  	default: key = null
	  }
	  
	  if(key)
	  {
		  field = document.getElementById('control_field')
		  if(isNaN(field.value))
		  {
			  field.value = 0
		  }
		  if(key == 'UP')
		  {
			  field.value++
		  }
		  else if(key == 'DOWN' && field.value > 0)
		  {
			  field.value--
		  }
	  }
  }
  
</script>