$(function() {
	$("input[type='checkbox']").change(function() {
		var check = this.checked;
		$.ajax({
			url: "/PhysicalDevelopment/notSubjectToEvaluation?notSubjectToEvaluation=" + check,
			type: "GET",
			dataType: "html",
			success: function(data) {
				console.log(data);
				console.log(check);
				document.getElementById("evaluation").innerHTML = data;
			},
			error: function(err) {
			}
		});
	});
});


jQuery( function() {
    jQuery . jqplot(
        'jqPlot-sample',
        [
            [ [ carbohydrate_percent, '炭水化物' ], [ lipid_percent, '脂質' ], [ protein_percent, 'たんぱく質' ], [ energy_percent, 'エネルギー' ] ]
        ],
        {
            seriesDefaults: {
                renderer: jQuery . jqplot . BarRenderer,
                rendererOptions: {
                    barDirection: 'horizontal'
                }
            },
            axes: {
                yaxis: {
                    renderer: jQuery . jqplot . CategoryAxisRenderer,
                }
            }
        }
    );
} );
