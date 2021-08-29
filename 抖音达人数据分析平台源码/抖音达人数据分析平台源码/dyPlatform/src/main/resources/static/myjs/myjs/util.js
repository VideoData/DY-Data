/*  格式化为千分位金额
　　 * number：要格式化的数字
　　 * decimals：保留几位小数
　　 * dec_point：小数点符号
　　 * thousands_sep：千分位符号
　　 * */
function formatToMoney(number, decimals, dec_point, thousands_sep) {
    number = (number + '').replace(/[^0-9+-Ee.]/g, '');
    var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 2 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function (n, prec) {
            var k = Math.pow(10, prec);
            return '' + Math.ceil(n * k) / k;
        };

    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
    var re = /(-?\d+)(\d{3})/;
    while (re.test(s[0])) {
        s[0] = s[0].replace(re, "$1" + sep + "$2");
    }

    if ((s[1] || '').length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1).join('0');
    }
    return s.join(dec);
}

/*
*js格式化数字代码
*
*value: 要格式化的数字值
*zeroed: 是否保留尾0
*scale: 最多保留几位小数
*percented: 是否转称百分比形式
*
*/
function formatNumber(value, scale, zeroed, percented) {
    if (value == null)
        return percented ? '0%' : 0;
    var mr = ('' + value).match(/^\d+\.?\d*$/);
    if (!mr)
        return percented ? '0%' : 0;
    mr = (percented ? (value = Number(mr[0]) * 100) + '' : mr[0]).split('.');
    if (mr.length == 1)
        return (zeroed ? (mr[0] + ((function () {
            var r = '.';
            for (var i = 0; i < scale; i++) {
                r += '0';
            }
            return r;
        }()))) : mr[0]) + (percented ? '%' : '');
    var mr_l = mr[0], mr_r = mr[1];
    if (mr_r.length == scale)
        return (zeroed ? (mr_l + '.' + mr_r) : (value + '').replace(/\.*0+$/, '')) + (percented ? '%' : '');
    else if (mr_r.length < scale)
        return (zeroed ? value + ((function () {
            var r = '';
            for (var i = 0; i < scale - mr_r.length; i++) {
                r += '0';
            }
            return r;
        })()) : (value + '').replace(/\.*0+$/, '')) + (percented ? '%' : '');
    else {
        var _s = mr_r.substr(0, scale + 1);
        _s = _s.charAt(scale) > 4 ? (Number(_s.substring(0, scale)) + 1) + '' : _s.substring(0, scale);
        if (_s.length == (scale + 1)) {
            mr_l = (Number(mr_l) + Number(_s.charAt(0))) + '';
            _s = _s.substring(1);
        }
        return (zeroed ? (mr_l + '.' + _s) : (mr_l + (_s.match(/^0*$/) ? '' : ('.' + _s.replace(/0+$/, '')))))
            + (percented ? '%' : '');
    }
};

/**
 *  将数字格式化为  xxx.xx W
 * @param number
 * @returns {string|*}
 */
function formatToW(number) {
    let first = number / 10000
    if (first >= 1) {
        return formatNumber(parseFloat(first), 2, false, false) + " W"
    } else {
        return number
    }
}

/**
 *  时间戳转换 yyyy-mm-dd
 * @param date
 * @returns {string}
 */
function formatDate(date) {
    var date = new Date(date);
    var YY = date.getFullYear() + '-';
    var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
    return YY + MM + DD ;
}