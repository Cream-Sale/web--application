$(function() {
	$('.form__choose').click(function () {
		$('.form__choose').removeClass('chosen');
		$(this).addClass('chosen');
	});

	$('.goods__open').click(function () {
		if ($('.goods__left').hasClass('opened')) {
			$('.goods__left').removeClass('opened');
		}
		else {
			$('.goods__left').addClass('opened');
		}
	});

	//menu fix when scrolling

        var $menu = $(".header");

        $(window).scroll(function(){
            if ( $(this).scrollTop() > 1  ){
                $menu.addClass("fixed");
                // $('.header__bottom').addClass("margT");
            } else if($(this).scrollTop() < 1 && $menu.hasClass("fixed")) {
                $menu.removeClass("fixed");
                // $('.header__bottom').removeClass("margT");
            }
        });//scroll
	

});
