<?php
/*
Plugin Name: Farrusco Control
Plugin URI: http://guibot.pt/
Description: Plugin for controlling Farrusco via web
Version: 1.0
Author: WidgiLabs, Lda
Author URI: http://www.widgilabs.com
License: GPL2
*/

add_action('wp_ajax_my_special_action', 'my_action_callback');
add_action('wp_ajax_nopriv_my_special_action', 'my_action_callback');

function microtime_float()
{
    list($usec, $sec) = explode(" ", microtime());
    return ((float)$usec + (float)$sec);
}



function my_action_callback() 
{
	$cmd = $_POST['cmd'];
	
	include 'XMPPHP/XMPP.php';
	
	error_reporting(0);

	//$time_start = microtime_float();
	$conn = new XMPPHP_XMPP('talk.google.com', 5222, 'n.d.santos1@gmail.com', 'ns171284', 'xmpphp', 'gmail.com', $printlog=false, $loglevel=XMPPHP_Log::LEVEL_INFO);
	
	try {
		$conn->connect();
	    $conn->processUntil('session_start');
	    $conn->presence();
	     //			$time_end = microtime_float();
	    $conn->message('farruscorobot@gmail.com', $cmd);
	    $conn->disconnect();
	} catch(XMPPHP_Exception $e) {
	    die($e->getMessage());
	}
	

	//$time = $time_end - $time_start;
	die();
	//die("TOTAL TIME = ".$time);
}

?>