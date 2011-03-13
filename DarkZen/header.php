<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<title><?php if (is_home () ) {  bloginfo(‘name’); }
elseif ( is_category() ) { single_cat_title(); echo ' - ' ; bloginfo(‘name’); }
elseif (is_single() ) { single_post_title();}
elseif (is_page() ) { single_post_title();}
else { wp_title(‘’,true); } ?></title>
	
	
	<link rel="stylesheet" href="<?php bloginfo('stylesheet_url'); ?>" type="text/css" media="screen" />
	<link rel="alternate" type="application/rss+xml" title="RSS 2.0" href="<?php bloginfo('rss2_url'); ?>" />
	<link rel="alternate" type="text/xml" title="RSS .92" href="<?php bloginfo('rss_url'); ?>" />
	<link rel="alternate" type="application/atom+xml" title="Atom 0.3" href="<?php bloginfo('atom_url'); ?>" />
	<link rel="pingback" href="<?php bloginfo('pingback_url'); ?>" />

	<?php wp_enqueue_script('jquery'); ?>

	<?php wp_get_archives('type=monthly&format=link'); ?>

	<?php wp_head(); ?>
</head>
<body>
<div id="body2">
	
<div id="menulinks">
		<ul id="navlist">
			<li><a href="<?php echo get_settings('home'); ?>">Home</a></li>
			<?php //wp_list_pages('title_li='); ?>
		</ul>
		<div id="rsslink"><a href="feed:<?php bloginfo('rss2_url'); ?>">RSS</a></div>
</div>


<div id="header">
  <div class="headleft">
	<h1><a href="<?php echo get_settings('home'); ?>"><?php echo 'FARRUSCO'; ?></a></h1>
	<div class="description"><?php echo 'Get on the line and control Farrusco for 30secs.'; ?></div>
  </div>
  <div class="headright"><a rel="nofollow" href="#"><img src="<?php bloginfo('template_directory'); ?>/images/headerLogo.jpg" border="0" title="insert title" alt="insert title" /></a>
  </div>

</div>

<div id="page">
<div id="mainarea">
<div id="contentarea">
