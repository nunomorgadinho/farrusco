<?php get_header(); ?>


		<?php if (have_posts()) : while (have_posts()) : the_post(); ?>
			
			<div class="post">
			
				<div class="posttop">
					<div class="dateicon">
						<div class="day"><?php the_time('d') ?></div> 
						<div class="month"><?php the_time('M') ?></div>
					</div>
					<div class="title">
						<div class="thetitle"><a href="<?php the_permalink() ?>" rel="bookmark" title="Permanent Link to <?php the_title(); ?>"><?php the_title(); ?></a></div>
						<div class="under">written by: <?php the_author(', ') ?></div>
					</div>
				</div>
			
				<div class="entry">
					<?php the_content() ?>
					<?php edit_post_link('Edit this entry.', '<p>', '</p>'); ?>
					<div class="postbottom">
						<a href="http://stumbleupon.com/submit?url=<?php the_permalink() ?>&amp;title=<?php the_title(); ?>" class="stumbleupon"></a>
						<a href="http://digg.com/submit?phase=2&amp;url=<?php the_permalink() ?>&amp;title=<?php the_title(); ?>" class="digg"></a>
						<a href="http://del.icio.us/post?url=<?php the_permalink() ?>&amp;title=<?php the_title(); ?>" class="delicious"></a>
						<a href="http://google.com/bookmarks/mark?op=edit&amp;bkmk=<?php the_permalink() ?>&amp;title=<?php the_title(); ?>" class="google"></a>
					</div>
				</div>
				
		
		<?php endwhile; endif; ?>
	
	</div>

<?php get_sidebar(); ?>

<?php get_footer(); ?>