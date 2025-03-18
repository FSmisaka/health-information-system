function drawLineChart(canvasId, labels, data, chartLabel, xAxisLabel, yAxisLabel) {
    var ctx = document.getElementById(canvasId).getContext('2d');

    var chart = new Chart(ctx, {
        type: 'line',  // 图表类型为折线图
        data: {
            labels: labels,  // x轴标签
            datasets: [{
                label: chartLabel,
                data: data,  // y轴数据
                borderColor: 'rgba(75, 192, 192, 1)',
                fill: false,  // 不填充
                tension: 0.1  // 曲折程度
            }]
        },
        options: {
            responsive: true,
            scales: {
                x: {
                    title: {
                        display: true,
                        text: xAxisLabel || '日期'
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: yAxisLabel || '值'
                    },
                    min: 0  // 设置y轴的最小值
                }
            }
        }
    });
}
