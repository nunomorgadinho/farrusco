<?php get_header(); ?>

   <?php if (have_posts()) : ?>
		
		<?php while (have_posts()) : the_post(); ?>
				
			<div class="post">
			
				<div class="posttop">
					<div class="dateicon">
						<div class="day"><?php the_time('d') ?></div> 
						<div class="month"><?php the_time('M') ?></div>
					</div>
					<div class="title">
						<div class="thetitle"><a href="<?php the_permalink() ?>" rel="bookmark" title="Permanent Link to <?php the_title(); ?>"><?php the_title(); ?></a></div>
						<div class="under">stored in: <?php the_category(', ') ?></div>
					</div>
				</div>
			
				<div class="entry">
					<?php the_content() ?>
					<div class="postbottom">
						<?php comments_popup_link('No Comments', '1 Comment', '% Comments', 'commentslink', 'Comments Off'); ?>
						<a href="http://stumbleupon.com/submit?url=<?php the_permalink() ?>&amp;title=<?php the_title(); ?>" class="stumbleupon"></a>
						<a href="http://digg.com/submit?phase=2&amp;url=<?php the_permalink() ?>&amp;title=<?php the_title(); ?>" class="digg"></a>
						<a href="http://del.icio.us/post?url=<?php the_permalink() ?>&amp;title=<?php the_title(); ?>" class="delicious"></a>
						<a href="http://google.com/bookmarks/mark?op=edit&amp;bkmk=<?php the_permalink() ?>&amp;title=<?php the_title(); ?>" class="google"></a>
					</div>
				</div>
				
				<?php comments_template(); ?>
			</div>
			
				<?php trackback_rdf(); ?>

		<?php endwhile; ?>
				<div class="navigation">
					<?php posts_nav_link('','','&laquo; Previous Entries') ?>
					<?php posts_nav_link('','Next Entries &raquo;','') ?>
				</div>
	<?php else : ?>

		<h2 class="center">Not Found</h2>
		<p class="center"><?php _e("Sorry, but you are looking for something that isn't here."); ?></p>

	<?php endif; ?>
	
<?php get_sidebar(); ?>
<?php get_footer(); ?>