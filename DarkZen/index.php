
<?php get_header(); ?>

			<div class="post">
			
				<div class="posttop">
					<div class="dateicon">
						<div class="day"><?php echo date('d'); ?></div> 
						<div class="month"><?php echo date('M') ?></div>
					</div>
					<div class="title">
						<div class="thetitle"><a href="" rel="bookmark" title="Permanent Link to Farrusco Place"><?php  echo 'Farrusco at Residência AZ'; ?></a></div>
					</div>
				</div>
			
	
			<div class="streaming" id="streaming">
				<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" width="480" height="296" id="utv949372">
				<param name="flashvars" value="autoplay=false&amp;brand=embed&amp;cid=7502326&amp;v3=1"/>
				<param name="allowfullscreen" value="true"/>
				<param name="allowscriptaccess" value="always"/>
				<param name="movie" value="http://www.ustream.tv/flash/viewer.swf"/>
				<embed flashvars="autoplay=false&amp;brand=embed&amp;cid=7502326&amp;v3=1" width="680" height="396" allowfullscreen="true" allowscriptaccess="always" id="utv949372" name="utv_n_951471" src="http://www.ustream.tv/flash/viewer.swf" type="application/x-shockwave-flash" />
				</object><br />
				<a href="http://www.ustream.tv/" style="padding: 2px 0px 4px; width: 400px; background: #ffffff; display: block; color: #000000; font-weight: normal; font-size: 10px; text-decoration: underline; text-align: center;" target="_blank"></a>
			</div>
			
			<br/>
			<div class="controlarea" id="controlarea" style="width: 450px; height: 400px; margin-left: auto; margin-right: auto" style="align:center">

				<textarea name="control"></textarea><br/>
				<h6>Keep the focus on the textarea to control the Camera or Farrusco</h6>
				<input type="radio" name="control">Camera Control</button>
				<input type="radio" name="control">Farrusco Control</button>

				<input type="text" id="debug" size="1" disabled value="" ></input>

			</div> 
			
			<div id="results_div"></div>
			
				<div class="entry">
					<div class="postbottom">
						<a href="http://del.icio.us/post?url=<?php the_permalink() ?>&amp;title=<?php echo 'Farrusco at Residência AZ'; ?>" class="delicious"></a>
						<a href="http://google.com/bookmarks/mark?op=edit&amp;bkmk=<?php the_permalink() ?>&amp;title=<?php echo 'Farrusco at Residência AZ'; ?>" class="google"></a>
					</div>
				</div>
				
		
			</div>
			
				<?php trackback_rdf(); ?>
			
	
<?php //get_sidebar(); ?>
<?php get_footer(); ?>

<script type="text/javascript">

  onload = function(){

	  field = document.getElementById('contentarea')
	  field.onkeydown = keyhit
	  field.focus()
  }
   
  function keyhit(e)
  {
	  thisKey = e ? e.which : window.event.keyCode

	  //alert(thisKey);
	  
	  switch (thisKey) {
	  	case 38: key = 'UP'
	  	send_to('F');
	  	break
	  	case 40: key = 'DOWN'
	  	send_to('B');
	  	break
	  	case 39: key = 'RIGHT'
	  	send_to('R');
		break
	  	case 37: key = 'LEFT'
	  	send_to('L');
		break
	  	case 67: key = 'C'
		break
	  	case 70: key = 'F'
		break
	  	case 83: key = 'S'
		send_to('S');
	  	default: key = null
	  }
  }

  function send_to(cmd)
  {
	  debug = document.getElementById('debug');
	  debug.value = cmd;
	  
	  var data = {
	 	action: "my_special_action",
		cmd: cmd,
		results_div_id: "results_div"
	  };

	  jQuery.post("<?php bloginfo('wpurl'); ?>/wp-admin/admin-ajax.php", data, function(response) {
		//alert('Got this from the server: ' + response);
  	  });
  }
  
</script>