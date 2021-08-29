

function reder(searchcondimm) {
    var option = {
        url: "js/data.json",
        searfunc: searfunc,
        searchcondimm: searchcondimm
    }

    function searfunc(arr) {
        //arr为查询按钮之后输出的搜索条件
        console.log(arr);
    }

    $("#searchcon").SEarch(option);
}