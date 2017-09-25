var browserSupport = {
	placeholder : 'placeholder' in document.createElement('input')
}

$(function() {
	// 模拟placeholder
	if (!browserSupport.placeholder) {
		$('input[placeholder],textarea[placeholder]').each(function() {
			var that = $(this), text = that.attr('placeholder'), oldType;
			if (that.val() === "") {
				that.val(text).addClass('placeholder');
			}
			that.focus(function() {
				// ie8下readonly依然可以上焦点的处理
				if (that.attr('readonly')) {
					that.blur();
					return;
				}

				that.removeClass('placeholder');

				if (that.val() === text) {
					that.val("");
				}
			}).blur(function() {
				if (that.val() === "") {
					that.val(text).addClass('placeholder');
					// 防止异常情况：当有placeholder类，且值不为空（代码设置值时容易出现）
				} else {
					that.removeClass('placeholder');
				}
			}).closest('form').submit(function() {
				if (that.val() === text) {
					that.val('');
				}
			});
		});
	}
});