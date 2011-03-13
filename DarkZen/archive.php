<?php get_header(); ?>

	<?php if (have_posts()) : ?>
		<div class="post">
		<?php while (have_posts()) : the_post(); ?>

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
					<?php the_excerpt() ?>
					<div class="postbottom">
						<?php comments_popup_link('No Comments', '1 Comment', '% Comments', 'commentslink', 'Comments Off'); ?>
						</div>
				</div>
			
		<?php endwhile; ?>

		<div class="navigation">
			<div class="alignleft"><?php next_posts_link('&laquo; Older Entries') ?></div>
			<div class="alignright"><?php previous_posts_link('Newer Entries &raquo;') ?></div>
		</div>

	<?php else : ?>

		<h2 class="center">No posts found. Try a different search?</h2>
		<?php include (TEMPLATEPATH . '/searchform.php'); ?>

	<?php endif; ?>

	</div>

<?php get_sidebar(); ?>
<?php get_footer(); ?>