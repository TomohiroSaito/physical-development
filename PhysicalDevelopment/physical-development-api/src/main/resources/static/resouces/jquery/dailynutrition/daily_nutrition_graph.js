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
