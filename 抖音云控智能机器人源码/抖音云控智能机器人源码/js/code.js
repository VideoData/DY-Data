
Java.perform(function () {
    
    // 加载obj.dex
    Java.openClassFile("/data/local/tmp/r0gson.dex").load();
    // -----------构造解析obj对象
    const gson = Java.use('com.r0ysue.gson.Gson').$new();
    // -----------构造HashMap类
    var HashMap = Java.use('java.util.HashMap');
    // ------------构造Object类
    var JavaObject = Java.use("java.lang.Object");
    // ------------构造ArrayList类
    var ArrayList = Java.use("java.util.ArrayList");

    // HOOK目标类
    var tt = Java.use('com.ss.sys.ces.gg.tt$1');

    // 解析请求头，构造hashmap
    function headers_map(headers){
      var hash_map = HashMap.$new()
      for(var k in headers){
        if(headers[k]!=''){
          var li = ArrayList.$new();
          if(k == 'Cookie'){
            var n = headers[k].replace(/=/,'\u003d').split('; ')
            for(var j = 0; j < n.length; j++){
              li.add(n[j]);
            }
          }else{
            li.add(headers[k]);
          }
          hash_map.put(k, li);
        }
      }
      return hash_map
    }
  
    // 主动调用
    rpc.exports = {
      xgorgon: function (url, headers) {
          var res = tt.$new().a(url, headers_map(headers));
          return gson.$new().toJson(res);
      }
    }


  //   console.log('----------hook-start---------------')

  //   var target_func = tt.a
  //   target_func.overload('java.lang.String', 'java.util.Map').implementation = function(a,b){
  //     if(a.indexOf("/feed/?") >= -1){  
  //       console.log(gson.$new().toJson(b))
  //       // var json_b = JSON.parse(gson.$new().toJson(b))s
  //       // for(var k in json_b){
  //       //   console.log(k + ':' + json_b[k]);
  //       // }
  //       // console.log(a)
  //     }
  //     return target_func.call(this, a, b)
  //   }

  //   console.log('----------hook-end---------------')
  });


