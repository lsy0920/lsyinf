<template>
  <div class="echartStyle">
    <div ref="myChart"  class="chartStyle"></div>
    <div ref="myLine" class="lineStyle"></div>
    <div ref="myPie" class="pieStyle"></div>
    <div ref="myPieOut" class="pieOutStyle"></div>
    <div ref="myCloud" class="cloudStyle"></div>
    <div ref="myWeekday" class="weekdayStyle"></div>
  </div>
  
</template>
<script>
export default {
  name: "Echarts",
  data() {
    return {
      chart: null,
      line: null,
      pie: null,
      pieOut: null,
      cloud: null,
      weekday: null,
      arrDay: [],
      arrPrice: [],
      arrMediaName: [],
      arrMedia: [],
      arrMediaNumbers: [],
      arrMediaSort: [],
      newArr: [],
      arr: [],
      sortName: [],
      arrPieName: [],
      weiBo: [],
      weiChat: [],
      tieBa: [],
      douYin: [],
      kuaiShou: [],
      // arrPieSort: [],
      // sortValue: 0,
      // arrSort: [],
      arrPieIn: [],
      arrCloud: [],
      
    };
  },
  mounted() {
    this.$nextTick(function() {
      this.initChart();
      this.drawMyChart();
      this.initLine();
      this.getChartLine();
      this.initPie();
      this.getChartPie();
      this.initPieOut();
      this.getPieOut();
      this.getPieIn();
      this.initCloud();
      this.getChartCloud();
      this.initWeekday();
      this.getWeibo();
      this.getWeiChat();
      this.getTieBa();
      this.getDouYin();
      this.getKuaiShou();

    });
    
  },

  methods: {
    initChart() {
      this.chart = this.$echarts.init(this.$refs.myChart);
    },
    initLine() {
      this.line = this.$echarts.init(this.$refs.myLine);
    },
    initPie() {
      this.pie = this.$echarts.init(this.$refs.myPie);
    },
    initPieOut() {
      this.pieOut = this.$echarts.init(this.$refs.myPieOut);
    },
    initCloud() {
      this.cloud = this.$echarts.init(this.$refs.myCloud);
    },
    initWeekday() {
      this.weekday = this.$echarts.init(this.$refs.myWeekday);
    },
    drawMyChart() {
      this.$http({
        method: "post",
        url: "/api/getClothesList"
      })
        .then(response => {
          // this.chartData = response.data;
          // Object.keys(this.chartData).map((key, item) => {
          //   this.nameData = this.chartData[key].clothesName;
          //   this.salesData = this.chartData[key].sales;

          let arrName = [];
          let arrSales = [];
          for (let i = 0; i < response.data.length; i++) {
            arrName.push(response.data[i].clothesName);
          }
          for (let i = 0; i < response.data.length; i++) {
            arrSales.push(response.data[i].sales);
          }
          let option = {
            title: { text: "在Vue中使用echarts" },
            tooltip: {}, //提示框
            xAxis: {
              data: arrName
            },
            yAxis: {},
            series: [
              {
                name: "销量",
                type: "bar",
                // data: [5, 20, 36, 10, 10, 20]
                data: arrSales
              }
            ]
          };
          this.chart.setOption(option);
        })
        .catch(function(error) {
          console.log(error);
        });
    },

    getChartLine() {
      this.$http({
        method: "post",
        url: "/api/getDay"
      })
        .then(response => {
          for (let i = 0; i < response.data.length; i++) {
            this.arrDay.push(response.data[i].clothesDay);
            this.arrPrice.push(response.data[i].clothesPrice);
          }
          this.drawMyLine();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    drawMyLine() {
      // let myLine = this.$echarts.init(document.getElementById("myLine"));
      var option = {
        title: { text: "折线图" },
        xAxis: {
          type: "category",
          data: this.arrDay
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            // data: [820, 932, 901, 934, 1290, 1330, 1320],
            data: this.arrPrice,
            type: "line"
          }
        ]
      };
      this.line.setOption(option);
    },

    getChartPie() {
      this.$http({
        method: "post",
        url: "/api/getPie"
      })
        .then(response => {
          for (let i = 0; i < response.data.length; i++) {
            this.arrMediaName.push(response.data[i].name);
          }
          this.arrMedia = response.data;
          this.arrMediaNumbers = response.data.length;
          this.drawMyPie();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    drawMyPie() {
      let option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          left: this.arrMediaNumbers,
          data: this.arrMediaName
        },
        color: [
          "#FFC125",
          "#FFB5C5",
          "#C6E2FF",
          "	#9F79EE",
          "#a0ff60",
          "#A2B5CD",
          "#FF7F24",
          "#F08080",
          "#60c0ff",
          "#2080ff"
        ],
        series: [
          {
            name: "访问来源",
            type: "pie",
            radius: ["40%", "55%"],

            label: {
              formatter: "{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ",
              backgroundColor: "#eee",
              borderColor: "#aaa",
              borderWidth: 1,
              borderRadius: 4,
              rich: {
                a: {
                  color: "#999",
                  lineHeight: 22,
                  align: "center"
                },
                hr: {
                  borderColor: "#aaa",
                  width: "100%",
                  borderWidth: 0.5,
                  height: 0
                },
                b: {
                  fontSize: 16,
                  lineHeight: 33
                },
                per: {
                  color: "#eee",
                  backgroundColor: "#334455",
                  padding: [2, 4],
                  borderRadius: 2
                }
              }
            },

            data: this.arrMedia
          }
        ]
      };
      // myPie.setOption(option);
      this.pie.setOption(option);
    },
    delRepeat(arr) {
      for (let i = 0; i < arr.length; i++) {
        if (this.newArr.indexOf(arr[i]) == -1) {
          this.newArr.push(arr[i]);
        }
      }
      return this.newArr;
    },
    //外环
    getPieOut() {
      this.$http({
        method: "post",
        url: "/api/getPieOut"
      })
        .then(response => {
          for (let i = 0; i < response.data.length; i++) {
            this.arrPieName.push(response.data[i].name);
            this.arrMediaSort.push(response.data[i].pieSort);
          }
          this.arrMediaSort = this.delRepeat(this.arrMediaSort);
          this.arrMedia = response.data;
          this.sortName = this.arrPieName.concat(this.arrMediaSort);
          // for (var i = 0; i < this.arrMediaSort.length; i++) {
          //   for (var j = 0; j < response.data.length; j++) {
          //     if (response.data[j].pieSort === this.arrMediaSort[i]) {
          //       this.sortValue = this.sortValue + parseInt(response.data[j].value);

          //     }

          //   }
          //   this.arrPie[i].name.push(this.arrMediaSort);
          //   this.arrPie[i].value.push(this.sortValue);
          //   this.arrPieSort.push(this.sortValue);
          //   this.sortValue = 0;
          // }

          this.drawTwoPie();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    //内环
    getPieIn() {
      this.$http({
        method: "post",
        url: "/api/getPieIn"
      })
        .then(response => {
          this.arrPieIn = response.data;
          this.drawTwoPie();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    drawTwoPie() {
      let option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          left: this.sortName.length,
          data: this.sortName
        },
        series: [
          {
            name: "访问来源",
            type: "pie",
            selectedMode: "single",
            radius: [0, "30%"],

            label: {
              position: "inner"
            },
            labelLine: {
              show: false
            },
            data: this.arrPieIn
            // data: [
            //     {value: 335, name: '直达', selected: true},
            //     {value: 679, name: '营销广告'},
            //     {value: 1548, name: '搜索引擎'}
            // ]
          },
          {
            name: "访问来源",
            type: "pie",
            radius: ["40%", "55%"],
            label: {
              formatter: "{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ",
              backgroundColor: "#eee",
              borderColor: "#aaa",
              borderWidth: 1,
              borderRadius: 4,
              rich: {
                a: {
                  color: "#999",
                  lineHeight: 22,
                  align: "center"
                },
                hr: {
                  borderColor: "#aaa",
                  width: "100%",
                  borderWidth: 0.5,
                  height: 0
                },
                b: {
                  fontSize: 16,
                  lineHeight: 33
                },
                per: {
                  color: "#eee",
                  backgroundColor: "#334455",
                  padding: [2, 4],
                  borderRadius: 2
                }
              }
            },
            data: this.arrMedia
          }
        ]
      };
      this.pieOut.setOption(option);
    },
    getChartCloud() {
      this.$http({
        method: "post",
        url: "/api/getCloud"
      })
        .then(response => {
          this.arrCloud = response.data;
          this.drawMyCloud();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    drawMyCloud() {
      let option = {
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        series: [
          {
            type: "wordCloud",
            //调整词之间的距离
            gridSize: 20,
            //用来调整字的大小范围
            sizeRange: [12, 50],
            //用来调整词的旋转方向，，[0,0]--代表着没有角度，也就是词为水平方向需要设置角度参考注释内容
            // rotationRange: [-45, 0, 45, 90],
            // rotationRange: [ 0,90],
            rotationRange: [-60, 60],
            shape: "pentagon",
            //词云图中的数据
            data: this.arrCloud,
            //随机生成字体颜色
            textStyle: {
              normal: {
                color: function() {
                  return (
                    "rgb(" +
                    [
                      Math.round(Math.random() * 160),
                      Math.round(Math.random() * 160),
                      Math.round(Math.random() * 160)
                    ].join(",") +
                    ")"
                  );
                }
              },
              emphasis: {
                shadowBlur: 10,
                shadowColor: "#333"
              }
            }
          }
        ]
      };
      this.cloud.setOption(option);
    },
    getWeibo() {
      this.$http({
        method: "post",
        url: "/api/getWeiBo"
      })
        .then(response => {
          for (let i = 0; i < response.data.length; i++) {
            this.weiBo.push(response.data[i].linePageview);
          }
          this.drawLine();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    getWeiChat() {
      this.$http({
        method: "post",
        url: "/api/getWeiChat"
      })
        .then(response => {
          for (let i = 0; i < response.data.length; i++) {
            this.weiChat.push(response.data[i].linePageview);
          }
          
          this.drawLine();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    getTieBa() {
      this.$http({
        method: "post",
        url: "/api/getTieBa"
      })
        .then(response => {
          for (let i = 0; i < response.data.length; i++) {
            this.tieBa.push(response.data[i].linePageview);
          }
          this.drawLine();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    getDouYin() {
      this.$http({
        method: "post",
        url: "/api/getDouYin"
      })
        .then(response => {
          for (let i = 0; i < response.data.length; i++) {
            this.douYin.push(response.data[i].linePageview);
          }
          // console.log(this.douYin);
          this.drawLine();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    getKuaiShou() {
      this.$http({
        method: "post",
        url: "/api/getKuaiShou"
      })
        .then(response => {
          for (let i = 0; i < response.data.length; i++) {
            this.kuaiShou.push(response.data[i].linePageview);
          }
          // console.log(this.kuaiShou);
          this.drawLine();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    drawLine() {
      let option = {
        title: {
          text: "折线图堆叠"
        },
        tooltip: {
          trigger: "axis"
        },
        legend: {
          data: ["微博", "微信", "贴吧", "抖音", "快手"]
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: ["周一", "周二", "周三", "周四", "周五"]
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            name: "微博",
            type: "line",
            stack: "总量",
            //stack: 数据堆叠，同个类目轴上系列配置相同的stack值后，后一个系列的值会在前一个系列的值上相加。
            // data: [120, 132, 101, 134, 90, 230, 210]
            data: this.weiBo
          },
          {
            name: "微信",
            type: "line",
            stack: "总量",
            data: this.weiChat
          },
          {
            name: "贴吧",
            type: "line",
            stack: "总量",
            data: this.tieBa
          },
          {
            name: "抖音",
            type: "line",
            stack: "总量",
            data: this.douYin
          },
          {
            name: "快手",
            type: "line",
            stack: "总量",
            data: this.kuaiShou
          }
        ]
      };
      this.weekday.setOption(option);
    }
  }
};
</script>
<style scoped>
.echartStyle {
  float: left;
}
.chartStyle {
  border-style: ridge; 
  border-width: 1px;
  width: 800px; 
  height: 450px;
  float: left;
  margin-top: 50px;
  margin-left: 30px;
}
.lineStyle {
  border-style: ridge; 
  border-width: 1px;
  width: 800px; 
  height: 450px;
  margin-top: 50px;
  float: left;
  margin-left: 30px;
}
.pieStyle {
  border-style: ridge; 
  border-width: 1px;
  width: 800px; 
  height: 450px;
  margin-top: 50px;
  float: left;
  margin-left: 30px;
}
.pieOutStyle {
  border-style: ridge; 
  border-width: 1px;
  width: 800px; 
  height: 450px;
  margin-top: 50px;
  float: left;
  margin-left: 30px;
}
.cloudStyle {
  border-style: ridge; 
  border-width: 1px;
  width: 800px; 
  height: 450px;
  margin-top: 50px;
  float: left;
  margin-left: 30px;
}
.weekdayStyle {
  border-style: ridge; 
  border-width: 1px;
  width: 800px; 
  height: 450px;
  margin-top: 50px;
  float: left;
  margin-left: 30px;
}
</style>
