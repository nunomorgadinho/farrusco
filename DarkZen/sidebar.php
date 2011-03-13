</div> <!-- CONTENTAREA -->

<div id="sidebar">

		<h2 style="margin-top:0;">Popular Articles</h2>
		<ul id="widelist">
		<li><a href="#">some sample link</a></li>
		<li><a href="#">some sample link</a></li>
		<li><a href="#">some sample link</a></li>
		<li><a href="#">some sample link</a></li>
		</ul>

		
		<h2>Advertisements</h2>
		<div id="advertarea">
			<div class="advert"><a href="#"><img src="<?php bloginfo('template_directory'); ?>/images/advert1.jpg" alt="advert1" /></a></div>
			<div class="advert"><a href="#"><img src="<?php bloginfo('template_directory'); ?>/images/advert2.jpg" alt="advert2" /></a></div>
			<div class="advert"><a href="#"><img src="<?php bloginfo('template_directory'); ?>/images/advert3.jpg" alt="advert3" /></a></div>
			<div class="advert"><a href="#"><img src="<?php bloginfo('template_directory'); ?>/images/advert1.jpg" alt="advert1" /></a></div>
			<div class="advert"><a href="#"><img src="<?php bloginfo('template_directory'); ?>/images/advert2.jpg" alt="advert2" /></a></div>
			<div class="advert"><a href="#"><img src="<?php bloginfo('template_directory'); ?>/images/advert3.jpg" alt="advert3" /></a></div>
			<br/><br/>		
		</div>
		
		<h2>Search Blog</h2>
		<form method="get" id="searchform" action="<?php echo $_SERVER['PHP_SELF']; ?>">
				<div><input type="text" value="<?php echo wp_specialchars($s, 1); ?>" name="s" id="s" />
				<input type="submit" id="searchsubmit" value=" " />
				</div>
		</form>	
	

	<div id="sidebar1">
			<ul>
			<?php if ( !function_exists('dynamic_sidebar') || !dynamic_sidebar('sidebar1') ) : ?>
				
				<?php wp_list_pages('title_li=<h2>' . __('Pages') . '</h2>' ); ?>
				
				<li><h2><?php _e('Archives'); ?></h2>
					<ul><?php wp_get_archives('type=monthly'); ?></ul>
				</li>

				
				
								
				<li><h2><?php _e('Meta'); ?></h2>
				<ul>
					<?php wp_register(); ?>
					<li><?php wp_loginout(); ?></li>
					<li><a href="http://validator.w3.org/check/referer" title="<?php _e('This page validates as XHTML 1.0 Transitional'); ?>"><?php _e('Valid <abbr title="eXtensible HyperText Markup Language">XHTML</abbr>'); ?></a></li>
					<li><a href="http://gmpg.org/xfn/"><abbr title="XHTML Friends Network">XFN</abbr></a></li>
					<li><a href="http://wordpress.org/" title="<?php _e('Powered by WordPress, state-of-the-art semantic personal publishing platform.'); ?>">WordPress</a></li>
					<?php wp_meta(); ?>
				</ul>
				</li>
			<?php endif; ?>
			</ul>
	</div>
	
	<div id="sidebar2">
			<ul>
			<?php if ( !function_exists('dynamic_sidebar') || !dynamic_sidebar('sidebar2') ) : ?>
				
				
				<li><h2><?php _e('Categories'); ?></h2>
					<ul><?php list_cats(0, '', 'name', 'asc', '', 1, 0, 0, 1, 1, 1, 0,'','','','','') ?></ul>
				</li>
				
				<?php get_links_list(); ?>
				
				
			<?php endif; ?>
			</ul>
	</div>
			
		
</div>
