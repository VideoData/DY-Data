var aesKEY
var aesiv
$.ajax({
    url: "/data/getAesdata",
    type: 'GET',
    async: false,
    success: function (ajaxdata) {
        if (ajaxdata.code == 200) {
            aesKEY = ajaxdata.data.key
            aesiv = ajaxdata.data.iv
        }
    }
})

// 加密
function encrypt(data) { //key,iv：16位的字符串
    var key1 = CryptoJS.enc.Latin1.parse(aesKEY);
    var iv1 = CryptoJS.enc.Latin1.parse(aesiv);
    return CryptoJS.AES.encrypt(data, key1, {
        iv: iv1,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.ZeroPadding
    }).toString();
}

// 解密
function decrypt(data) { //key,iv：16位的字符串
    var key1 = CryptoJS.enc.Latin1.parse(aesKEY);
    var iv1 = CryptoJS.enc.Latin1.parse(aesiv);
    var decrypted = CryptoJS.AES.decrypt(data, key1, {
        iv: iv1,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.ZeroPadding
    });
    return decrypted.toString(CryptoJS.enc.Utf8);
}