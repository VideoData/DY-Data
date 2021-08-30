"auto";

var width = device.width/2
var height = device.height/2




// 82
function letter_o(r, den, ts){
    for(var i=-r; i<=r; i=i+den){
        var x = width + i
        var y0 = Math.sqrt(r*r - Math.pow((x-width), 2)) + height
        var y1 = height - Math.sqrt(r*r - Math.pow((x-width), 2)) 
        console.log(x)
        console.log(y0)
        press(x, y0, ts)
        press(x, y1, ts)

    }
}

function letter_i(r, den, ts){
    var o = 0
    for(var i=-r; i<=r; i=i+den){
        o = o+1
        console.log(o);
        if(o == 1 ){
            for(var j=-r/4; j<=r/4; j=j+den){
                var x = width + j
                var y = height - r 
                console.log(x);
                press(x, y, ts)
            }
        }else if(o == r*2/den){
            for(var j=r/3; j>=-r/3; j=j-den){
                var x = width + j
                var y = height + r 
                press(x, y, ts)
            }
        }
        var x = width 
        var y = height + i
        press(x, y, ts)
    
    }
    
}


letter_o(300,20,50)
letter_i(400,20,50)