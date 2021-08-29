showActiveNav()

function showActiveNav() {
    let mynav = $("#mynavs")
    mynav.empty()
    let html = ""
    let isFirst = true
    let alldata = getCandidateListControl()
    if (alldata && alldata.num > 0) {
        let indata = alldata.data
        for (let i = 0; i < indata.length; i++) {
            if (indata[i].uniqueid == alldata.currentNum) {
                html += "<div class='mynavAcitve' data-index='" + indata[i].uniqueid + "'>第" + indata[i].uniqueid + "达人</div>"
                isFirst = false
            } else {
                html += "<div data-index='" + indata[i].uniqueid + "'>第" + indata[i].uniqueid + "达人</div>"
            }
        }
    }
    let firstHtml = ""
    if (isFirst) {
        firstHtml = "<div class='mynavAcitve' data-index='0'>候选达人</div>"
    } else {
        firstHtml = "<div data-index='0'>候选达人</div>"
    }
    html = firstHtml + html
    mynav.append(html)
    alert(html)
}

$("#candidate_total_price_span").text("abc")