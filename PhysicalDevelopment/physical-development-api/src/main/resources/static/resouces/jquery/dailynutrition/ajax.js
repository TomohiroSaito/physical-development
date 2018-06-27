$(function() {
	$("input[type='checkbox']").change(function() {
		var check = this.checked;
		$.ajax({
			url: "/PhysicalDevelopment/notSubjectToEvaluation?notSubjectToEvaluation=" + check,
			type: "GET",
			dataType: "html",
			success: function(data) {
				console.log(check);
				console.log(data);
				document.getElementById("evaluation").innerHTML = data;
			},
			error: function(err) {
			}
		});
	});
});
