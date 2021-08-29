(window.webpackJsonp = window.webpackJsonp || []).push([[5], {
    4931: function (t, e, n) {
        (function (t, n, r) {
            !function (e) {
                "use strict";

                function o(t) {
                    return (o = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
                        return typeof t
                    } : function (t) {
                        return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
                    })(t)
                }

                function i() {
                    return (i = Object.assign || function (t) {
                        for (var e = 1; e < arguments.length; e++) {
                            var n = arguments[e];
                            for (var r in n) Object.prototype.hasOwnProperty.call(n, r) && (t[r] = n[r])
                        }
                        return t
                    }).apply(this, arguments)
                }

                Array.prototype.forEach || (Array.prototype.forEach = function (t) {
                    var e, n;
                    if (null == this) throw new TypeError("this is null or not defined");
                    var r = Object(this), o = r.length >>> 0;
                    if ("function" != typeof t) throw new TypeError(t + " is not a function");
                    for (1 < arguments.length && (e = arguments[1]), n = 0; n < o;) {
                        var i = void 0;
                        n in r && (i = r[n], t.call(e, i, n, r)), n++
                    }
                }), function () {
                    if (!(window.URL && window.URL.prototype && "href" in window.URL.prototype)) {
                        e.prototype = {
                            toString: function () {
                                return this.href
                            }, get href() {
                                return this._anchorElement.href
                            }, set href(t) {
                                this._anchorElement.href = t
                            }, get protocol() {
                                return this._anchorElement.protocol
                            }, set protocol(t) {
                                this._anchorElement.protocol = t
                            }, get host() {
                                return this._anchorElement.host
                            }, set host(t) {
                                this._anchorElement.host = t
                            }, get hostname() {
                                return this._anchorElement.hostname
                            }, set hostname(t) {
                                this._anchorElement.hostname = t
                            }, get port() {
                                return this._anchorElement.port
                            }, set port(t) {
                                this._anchorElement.port = t
                            }, get pathname() {
                                return this._anchorElement.pathname
                            }, set pathname(t) {
                                this._anchorElement.pathname = t
                            }, get search() {
                                return this._anchorElement.search
                            }, set search(t) {
                                this._anchorElement.search = t
                            }, get hash() {
                                return this._anchorElement.hash
                            }, set hash(t) {
                                this._anchorElement.hash = t
                            }
                        };
                        var t = window.URL || window.webkitURL || window.mozURL;
                        e.createObjectURL = function (e) {
                            return t.createObjectURL.apply(t, [e])
                        }, e.revokeObjectURL = function (e) {
                            return t.revokeObjectURL.apply(t, [e])
                        }, Object.defineProperty(e.prototype, "toString", {enumerable: !1}), window.URL = e
                    }

                    function e(t, e) {
                        if (!t) throw new TypeError("Invalid argument");
                        var n = document.implementation.createHTMLDocument("");
                        if (e) {
                            var r = n.createElement("base");
                            r.href = e, n.head.appendChild(r)
                        }
                        var o = n.createElement("a");
                        if (o.href = t, n.body.appendChild(o), ":" === o.protocol || !/:/.test(o.href)) throw new TypeError("Invalid URL");
                        Object.defineProperty(this, "_anchorElement", {value: o})
                    }
                }(), function () {
                    if (!Element.prototype.addEventListener) {
                        var t = [], e = function (e, n) {
                            function r(t) {
                                t.target = t.srcElement, t.currentTarget = o, void 0 !== n.handleEvent ? n.handleEvent(t) : n.call(o, t)
                            }

                            var o = this;
                            if ("DOMContentLoaded" === e) {
                                var i = function (t) {
                                    "complete" === document.readyState && r(t)
                                };
                                if (document.attachEvent("onreadystatechange", i), t.push({
                                    object: this,
                                    type: e,
                                    listener: n,
                                    wrapper: i
                                }), "complete" === document.readyState) {
                                    var a = new Event;
                                    a.srcElement = window, i(a)
                                }
                            } else this.attachEvent("on" + e, r), t.push({
                                object: this,
                                type: e,
                                listener: n,
                                wrapper: r
                            })
                        }, n = function (e, n) {
                            for (var r = 0; r < t.length;) {
                                var o = t[r];
                                if (o.object === this && o.type === e && o.listener === n) {
                                    "DOMContentLoaded" === e ? this.detachEvent("onreadystatechange", o.wrapper) : this.detachEvent("on" + e, o.wrapper), t.splice(r, 1);
                                    break
                                }
                                ++r
                            }
                        };
                        Element.prototype.addEventListener = e, Element.prototype.removeEventListener = n, HTMLDocument && !HTMLDocument.prototype.addEventListener && (HTMLDocument.prototype.addEventListener = e, HTMLDocument.prototype.removeEventListener = n), Window && !Window.prototype.addEventListener && (Window.prototype.addEventListener = e, Window.prototype.removeEventListener = n)
                    }
                }();
                var a = function (t, e) {
                    return (a = Object.setPrototypeOf || {__proto__: []} instanceof Array && function (t, e) {
                        t.__proto__ = e
                    } || function (t, e) {
                        for (var n in e) e.hasOwnProperty(n) && (t[n] = e[n])
                    })(t, e)
                };

                function s(t, e) {
                    function n() {
                        this.constructor = t
                    }

                    a(t, e), t.prototype = null === e ? Object.create(e) : (n.prototype = e.prototype, new n)
                }

                var c = function () {
                    return (c = Object.assign || function (t) {
                        for (var e, n = 1, r = arguments.length; n < r; n++) for (var o in e = arguments[n]) Object.prototype.hasOwnProperty.call(e, o) && (t[o] = e[o]);
                        return t
                    }).apply(this, arguments)
                };

                function u(t) {
                    var e = "function" == typeof Symbol && t[Symbol.iterator], n = 0;
                    return e ? e.call(t) : {
                        next: function () {
                            return t && n >= t.length && (t = void 0), {value: t && t[n++], done: !t}
                        }
                    }
                }

                function l(t, e) {
                    var n = "function" == typeof Symbol && t[Symbol.iterator];
                    if (!n) return t;
                    var r, o, i = n.call(t), a = [];
                    try {
                        for (; (void 0 === e || 0 < e--) && !(r = i.next()).done;) a.push(r.value)
                    } catch (t) {
                        o = {error: t}
                    } finally {
                        try {
                            r && !r.done && (n = i.return) && n.call(i)
                        } finally {
                            if (o) throw o.error
                        }
                    }
                    return a
                }

                function p() {
                    for (var t = [], e = 0; e < arguments.length; e++) t = t.concat(l(arguments[e]));
                    return t
                }

                function h(t) {
                    return "object" === o(t) && null !== t && !v(t)
                }

                function d(t) {
                    return "function" == typeof t
                }

                function f(t) {
                    return "[object String]" === Object.prototype.toString.call(t)
                }

                function v(t) {
                    return "[object Array]" === Object.prototype.toString.call(t)
                }

                function _(t) {
                    return "number" == typeof t
                }

                function m() {
                    if (!("fetch" in window)) return !1;
                    try {
                        return new Headers, new Request(""), new Response, !0
                    } catch (t) {
                        return !1
                    }
                }

                function g() {
                    return !!h(window)
                }

                function y() {
                    return !!g() && !!h(window.performance)
                }

                function b() {
                    return !!y() && !!h(window.performance.timing)
                }

                function w() {
                    return !!y() && !!d(window.performance.getEntries)
                }

                var E = (S.prototype._send = function (t) {
                }, S.prototype.setupTransport = function (t) {
                    var e = this;
                    this._transport = t, this._sendQueue.forEach((function (t) {
                        e._sendEvent(t)
                    })), this._sendQueue = []
                }, S);

                function S(t) {
                    var e = this;
                    this._setupMonitors = function (t) {
                        return t.forEach((function (t) {
                            t.setup(e._sendEvent)
                        })), t
                    }, this._sendEvent = function (t) {
                        if (e._transport) {
                            var n = e._modifyEvent(t);
                            e._shouldSend(n) && e._idleSendEvent(n)
                        } else e._sendQueue.push(t)
                    }, this._modifyEvent = function (t) {
                        return t
                    }, this._shouldSend = function (t) {
                        return !0
                    }, this._getIdle = function () {
                        return d(window.requestIdleCallback) ? window.requestIdleCallback : d(setTimeout) ? setTimeout : function (t) {
                            t()
                        }
                    }, this._idleSendEvent = function (t) {
                        e._getIdle()((function () {
                            e._send(t)
                        }))
                    }, this._options = t, this._sendQueue = [], this._monitors = this._setupMonitors(t.defaultMonitors || [])
                }

                function x(t, e) {
                    return Object.prototype.hasOwnProperty.call(t, e)
                }

                function k(t, e) {
                    var n, r;
                    if (void 0 === t.length) for (n in t) x(t, n) && e.call(null, n, t[n]); else if (r = t.length) for (n = 0; n < r; n++) e.call(null, n, t[n])
                }

                function T() {
                    for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
                    for (var n = {}, r = 0; r < t.length;) n = O(n, t[r]), r++;
                    return n
                }

                function O(t, e) {
                    for (var n in e) Object.prototype.hasOwnProperty.call(e, n) && void 0 !== e[n] && (h(t[n]) && h(e[n]) ? O(t[n], e[n]) : !h(t[n]) && h(e[n]) ? t[n] = O({}, e[n]) : t[n] = e[n]);
                    return t
                }

                function j(t, e) {
                    if (!v(t)) return !1;
                    if (0 === t.length) return !1;
                    for (var n = 0; n < t.length;) {
                        if (t[n] === e) return !0;
                        n++
                    }
                    return !1
                }

                function C(t, e, n) {
                    var r, o;
                    if (!e) return n;
                    var i = t, a = e.split(".");
                    try {
                        for (var s = u(a), c = s.next(); !c.done; c = s.next()) if (!(i = i[c.value])) return n
                    } catch (t) {
                        r = {error: t}
                    } finally {
                        try {
                            c && !c.done && (o = s.return) && o.call(s)
                        } finally {
                            if (r) throw r.error
                        }
                    }
                    return i
                }

                function R(t) {
                    var e = document.createElement("a");
                    e.href = t;
                    var n = e.pathname || "/";
                    return "/" !== n[0] && (n = "/" + n), {
                        href: e.href,
                        protocol: e.protocol.slice(0, -1),
                        hostname: e.hostname,
                        host: e.host,
                        pathname: n,
                        hash: e.hash
                    }
                }

                function L(t) {
                }

                function P(t) {
                    return d(t) ? t : L
                }

                function M(t) {
                    "complete" !== document.readyState ? window.addEventListener("load", (function () {
                        setTimeout((function () {
                            t()
                        }), 0)
                    }), !1) : t()
                }

                function D(t) {
                    if (!t) return "";
                    if (!d(t.forEach)) return "";
                    var e = [];
                    return t.forEach((function (t) {
                        e.push(t[0] + ": " + t[1])
                    })), e.join("\r\n")
                }

                function I(t) {
                    var e = {}, n = R(t);
                    return e.ax_protocol = n.protocol, e.ax_domain = n.hostname, e.ax_path = n.pathname, e.ax_url = n.href || t, e
                }

                function N(t, e) {
                    var n, r;
                    if (!t || !e) return "";
                    var o = t.split(";"), i = {};
                    try {
                        for (var a = u(o), s = a.next(); !s.done; s = a.next()) {
                            var c = s.value.split("="), l = f(c[0]) && c[0].trim();
                            l && f(c[1]) && (i[l] = c[1].trim())
                        }
                    } catch (t) {
                        n = {error: t}
                    } finally {
                        try {
                            s && !s.done && (r = a.return) && r.call(a)
                        } finally {
                            if (n) throw n.error
                        }
                    }
                    return i[e] || ""
                }

                function A(t) {
                    return v(t) && t.length ? function (t) {
                        for (var e = [], n = t.length, r = 0; r < n; r++) {
                            var o = t[r];
                            f(o) ? e.push(o.replace(/([.*+?^=!:${}()|\[\]\/\\])/g, "\\$1")) : o && o.source && e.push(o.source)
                        }
                        return new RegExp(e.join("|"), "i")
                    }(t) : null
                }

                function U() {
                    var t = function () {
                        for (var t = new Array(16), e = 0, n = void 0; e < 16; e++) 0 == (3 & e) && (n = 4294967296 * Math.random()), t[e] = n >>> ((3 & e) << 3) & 255;
                        return t
                    }();
                    return t[6] = 15 & t[6] | 64, t[8] = 63 & t[8] | 128, function (t) {
                        for (var e = [], n = 0; n < 256; ++n) e[n] = (n + 256).toString(16).substr(1);
                        var r = 0;
                        return [e[t[r++]], e[t[r++]], e[t[r++]], e[t[r++]], "-", e[t[r++]], e[t[r++]], "-", e[t[r++]], e[t[r++]], "-", e[t[r++]], e[t[r++]], "-", e[t[r++]], e[t[r++]], e[t[r++]], e[t[r++]], e[t[r++]], e[t[r++]]].join("")
                    }(t)
                }

                var H = ["/log/sentry/"], F = "i.snssdk.com", B = "SLARDAR_WEB_ID", q = U(), W = U(),
                    X = (Y.prototype.postEvent = function (t) {
                        var e = c(c({}, t), this._getCommonParams());
                        Y.post(this._url, e)
                    }, Y.prototype.getEvent = function (t) {
                        var e = function (t) {
                            var e, n = function (t) {
                                if (!h(t)) return {};
                                var e = {};
                                return k(t, (function (t, n) {
                                    h(n) || v(n) ? e[t] = JSON.stringify(n) : e[t] = n
                                })), e
                            }(t), r = (e = {}, k(n, (function (t, n) {
                                e[encodeURIComponent(t)] = encodeURIComponent(n)
                            })), e), o = [];
                            return k(r, (function (t, e) {
                                o.push(t + "=" + e)
                            })), o.join("&")
                        }(c(c({}, t), this._getCommonParams())), n = this._url + "?" + e;
                        Y.get(n)
                    }, Y.post = function (t, e, n) {
                        var r = n ? P(n.success) : L, o = n ? P(n.fail) : L, i = new XMLHttpRequest;
                        i.open("POST", t, !0), i.setRequestHeader("Content-Type", "application/json"), i.send(JSON.stringify(e)), i.addEventListener("load", (function () {
                            try {
                                if (this.responseText) {
                                    var t = JSON.parse(this.responseText);
                                    r(t)
                                } else r()
                            } catch (t) {
                                o()
                            }
                        })), i.addEventListener("error", (function () {
                            o()
                        })), i.addEventListener("abort", (function () {
                            o()
                        }))
                    }, Y.get = function (t, e) {
                        var n = e ? P(e.success) : L, r = e ? P(e.fail) : L, o = new XMLHttpRequest;
                        o.open("GET", t), o.send(), o.addEventListener("load", (function () {
                            try {
                                if (this.responseText) {
                                    var t = JSON.parse(this.responseText);
                                    n(t)
                                } else n()
                            } catch (t) {
                                r()
                            }
                        })), o.addEventListener("error", (function () {
                            r()
                        })), o.addEventListener("abort", (function () {
                            r()
                        }))
                    }, Y.prototype._getUrl = function () {
                        return "https://" + (this._options.reportDomain || F) + "/log/sentry/v2/api/slardar/main/"
                    }, Y.prototype._getCommonParams = function () {
                        return {timestamp: Date.now()}
                    }, Y);

                function Y(t) {
                    this._options = t || {}, this._url = this._getUrl()
                }

                function z() {
                    return d(Date) ? Math.round(Date.now() / 1e3) : 0
                }

                function V(t, e) {
                    if (!h(t)) return {};
                    if (!d(e)) return {};
                    var n = {};
                    return k(t, (function (t, r) {
                        e(r) && (n[t] = r)
                    })), n
                }

                var J, G = (s($, J = E), $.prototype.setupTransport = function () {
                    var t = new X({reportDomain: this._options.commonParams.report_domain});
                    J.prototype.setupTransport.call(this, t)
                }, $.prototype._send = function (t) {
                    var e = t.event || {};
                    e = c(c({}, e), this._normalizeCommonParams(this._options.commonParams || {})), this._options.custom && d(this._options.custom.beforeSend) && !(e = this._options.custom.beforeSend(e)) || ("get" !== t.type ? "post" === t.type && this._transport.postEvent(e) : this._transport.getEvent(e))
                }, $.prototype._sendPageview = function () {
                    d(this._sendEvent) && this._sendEvent({name: "PageView", type: "get", event: {ev_type: "pageview"}})
                }, $.prototype.emitEvent = function (t) {
                    var e = function (t) {
                        var e, n, r, o, i, a, s = null;
                        return h(t) && ("timer" === t.type && (s = h(e = t.event) && f(e.name) && _(e.value) ? {
                            metrics_type: "timer",
                            event_name: "default",
                            metrics: ((n = {})[e.name] = e.value, n),
                            category: V(e.tags, f),
                            timestamp: z()
                        } : {}), "counter" === t.type && (s = h(r = t.event) && f(r.name) && _(r.value) ? {
                            metrics_type: "counter",
                            event_name: "default",
                            metrics: ((o = {})[r.name] = r.value, o),
                            category: V(r.tags, f),
                            timestamp: z()
                        } : {}), "log" === t.type && (s = h(i = t.event) && f(i.value) ? {
                            metrics_type: "log",
                            event_name: "default",
                            log_content: i.value,
                            log_level: i.level || "info",
                            category: V(i.tags, f),
                            timestamp: z()
                        } : {}), "custom" === t.type && (s = h(a = t.event) && f(a.event_name) ? {
                            metrics_type: "custom",
                            event_name: a.event_name,
                            metrics: V(a.metrics, _),
                            category: V(a.tags, f),
                            timestamp: z()
                        } : {})), s
                    }(t);
                    this._emitSingleEvent(e)
                }, $);

                function $() {
                    var t = null !== J && J.apply(this, arguments) || this;
                    return t.sendEvent = function (e) {
                        d(t._sendEvent) && t._sendEvent(e)
                    }, t._shouldSend = function (e) {
                        var n = e.name, r = e.event;
                        if (!e.event) return !1;
                        if ("AjaxMonitor" === n || "FetchMonitor" === n) {
                            var o = A(H);
                            if (o && o.test(r.ax_url)) return !1;
                            var i, a = t._options.monitors.AjaxMonitor.whitelistUrls;
                            if (v(a) && 0 < a.length) {
                                var s = A(t._options.monitors.AjaxMonitor.whitelistUrls || []);
                                return !(!s || !s.test(r.ax_url))
                            }
                            if ((i = A(t._options.monitors.AjaxMonitor.ignore || [])) && i.test(r.ax_url)) return !1;
                            if (!t._options.monitors.AjaxMonitor.hookFetch) return !1
                        }
                        if ("StaticErrorMonitor" === n && (i = A(t._options.monitors.StaticErrorMonitor.ignore || [])) && i.test(r.st_src)) return !1;
                        if ("PathMonitor" !== n) return "HijackMonitor" !== n || Math.random() < t._options.monitors.HijackMonitor.sampleRate;
                        var c = t._options.plugins;
                        return !!(c && c.spa && c.spa.enable && r.type === c.spa.type)
                    }, t._modifyEvent = function (e) {
                        var n = e.name, r = e.type, o = e.event, i = c({}, o);
                        if ("PerformanceMonitor" !== n) return "PathMonitor" === n ? (t._options.plugins.spa.enable && t._options.plugins.spa.type === i.type && (t.updateConfig({commonParams: {pid: i.path}}), delete i.type, delete i.path), {}) : e;
                        var a = t._options.monitors.PerformanceMonitor;
                        if (!b()) return {};
                        var s = window.performance.timing, u = s.loadEventEnd - s.navigationStart > a.slowSessionTime;
                        if (i.resources && v(i.resources)) {
                            var l = A(t._options.monitors.PerformanceMonitor.geckoUrls || []);
                            k(i.resources, (function (t, e) {
                                h(i.resources[t]) && d(i.resources[t].toJSON) && (i.resources[t] = i.resources[t].toJSON(), i.resources[t].is_gecko = l && l.test(e.name || "") ? "1" : "0")
                            }))
                        }
                        return Math.random() < a.resourceSampleRate ? i = c(c({}, i), {
                            upload_reason: "sample",
                            resource_samplerate: t._options.monitors.PerformanceMonitor.resourceSampleRate
                        }) : u ? i = c(c({}, i), {upload_reason: "slow_session"}) : delete i.resources, {
                            name: n,
                            type: r,
                            event: i
                        }
                    }, t._normalizeOptions = function (e) {
                        return T({}, t._options, e)
                    }, t._normalizeCommonParams = function (t) {
                        var e = c({}, t);
                        return h(t.context) && (e.context = JSON.stringify(t.context)), e || {}
                    }, t.updateConfig = function (e) {
                        var n = t._options.commonParams.pid;
                        t._options = t._normalizeOptions(e), e.commonParams.pid !== n && t._sendPageview()
                    }, t.sendPageview = function () {
                        t._sendPageview()
                    }, t.sendCustomTimeLog = function (e, n, r) {
                        !function (t, e) {
                            var n = t.name, r = t.tag;
                            if (n) {
                                var o = {ev_type: "custom", cm_name: n, cm_type: "time", cm_value: +t.value};
                                r && (o.cm_tag = r), e({name: "SentCustomTime", type: "get", event: o})
                            }
                        }({name: e, tag: n, value: r}, t._sendEvent)
                    }, t.sendCustomCountLog = function (e, n) {
                        !function (t, e) {
                            var n = t.name, r = t.tag;
                            if (n) {
                                var o = {ev_type: "custom", cm_name: n, cm_type: "count"};
                                r && (o.cm_tag = r), e({name: "SentCustomCount", type: "get", event: o})
                            }
                        }({name: e, tag: n}, t._sendEvent)
                    }, t._emitSingleEvent = function (e) {
                        e && (e && !e.event_name || d(t._sendEvent) && t._sendEvent({
                            name: "Emit",
                            type: "post",
                            event: {ev_type: "flexible", flexible_data_list: [e]}
                        }))
                    }, t
                }

                var K = function () {
                    var t = this;
                    this.name = "StaticErrorMonitor", this.setup = function (e) {
                        g() && (t._callback = e, window.addEventListener("error", t.staticErrorLog, !0))
                    }, this._getParams = function (t, e) {
                        var n = {ev_type: "static", st_type: e}, r = R(t);
                        return n.st_src = t, n.st_protocol = r.protocol, n.st_domain = r.hostname, n.st_path = r.pathname, n
                    }, this.getSrc = function (t) {
                        return t && d(t.getAttribute) ? t.getAttribute("src") : t.src || t.href || ""
                    }, this.staticErrorLog = function (e) {
                        var n, r = e || window.event || {};
                        try {
                            n = r.target || r.srcElement || {}
                        } catch (r) {
                            return
                        }
                        var o = t.getSrc(n), i = n.tagName && n.tagName.toLowerCase() || "";
                        o && i && o !== window.location.href && d(t._callback) && t._callback({
                            name: t.name,
                            type: "get",
                            event: t._getParams(o, i)
                        })
                    }
                }, Q = (Z.prototype.setup = function (t) {
                    d(XMLHttpRequest) && (this._callback = t, this._start())
                }, Z.prototype._hookXMLHttpRequestOnreadystatechange = function (t) {
                    var e = this.onreadystatechange, n = this;
                    this.onreadystatechange = function () {
                        for (var r = [], o = 0; o < arguments.length; o++) r[o] = arguments[o];
                        if (4 === this.readyState) {
                            var i = {
                                ev_type: "ajax",
                                ax_status: this.status,
                                ax_type: n._method,
                                ax_request_header: D(n._requestHeaders || [])
                            };
                            i.ax_duration = Date.now() - n._start, 200 === this.status && (i.ax_size = function (t) {
                                var e = 0;
                                if ("" === t.responseType || "text" === t.responseType) e = tt(t.responseText); else if (t.response) e = tt(t.response); else try {
                                    e = tt(t.responseText)
                                } catch (t) {
                                    e = 0
                                }
                                return e
                            }(this)), "function" == typeof this.getAllResponseHeaders && (i.ax_response_header = this.getAllResponseHeaders()), i = c(c({}, i), I(n._url)), d(t._callback) && t._callback({
                                name: t.name,
                                type: "get",
                                event: i
                            })
                        }
                        if (e) return e.apply(this, r)
                    }
                }, Z);

                function Z() {
                    var t = this;
                    this.name = "AjaxMonitor", this._start = function () {
                        t._hookXMLHttpRequestOpen(), t._hookXMLHttpRequestSend(), t._hookXMLHttpRequestSetRequestHeader()
                    }, this._hookXMLHttpRequestSetRequestHeader = function () {
                        var t = XMLHttpRequest.prototype.setRequestHeader;
                        XMLHttpRequest.prototype.setRequestHeader = function () {
                            for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                            return this._requestHeaders = this._requestHeaders || [], this._requestHeaders.push(e), t.apply(this, e)
                        }
                    }, this._hookXMLHttpRequestOpen = function () {
                        var t = XMLHttpRequest.prototype.open;
                        XMLHttpRequest.prototype.open = function () {
                            for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                            var r = e[0], o = e[1];
                            return this._url = o && o.split("?")[0] || "", this._method = r && r.toLowerCase() || "", t.apply(this, e)
                        }
                    }, this._hookXMLHttpRequestSend = function () {
                        var e = t, n = XMLHttpRequest.prototype.send;
                        XMLHttpRequest.prototype.send = function () {
                            for (var t = [], r = 0; r < arguments.length; r++) t[r] = arguments[r];
                            return e._hookXMLHttpRequestOnreadystatechange.call(this, e), this._start = Date.now(), n.apply(this, t)
                        }
                    }
                }

                function tt(t) {
                    var e = "[object String]" === Object.prototype.toString.call(t);
                    return t ? e ? t.length : ArrayBuffer && t instanceof ArrayBuffer ? t.byteLength : window.Blob && t instanceof Blob ? t.size : t.length ? t.length : 0 : 0
                }

                var et = function () {
                    var t = this;
                    this.name = "FetchMonitor", this.setup = function (e) {
                        m() && (t._callback = e, t._start())
                    }, this._start = function () {
                        m() && t._hookFetch()
                    }, this._hookFetch = function () {
                        var e = t, n = window.fetch;
                        window.fetch = function (r, o) {
                            o = o || {};
                            var i = Date.now(), a = {ev_type: "ajax"}, s = t._getFetchUrl(r), u = t._getFetchMethod(r);
                            return a.ax_type = (o.method || u).toLowerCase(), a = c(c({}, a), I(s)), n(r, o).then((function (t) {
                                return a.ax_status = t.status, a.ax_duration = Date.now() - i, a.ax_response_header = e._getAllResponseHeaders(t), a.ax_request_header = e._getFetchHeaders(r, o), t.headers && d(t.headers.has) && t.headers.has("content-length") ? a.ax_size = Number(t.headers.get("content-length")) || 0 : a.ax_size = 0, d(e._callback) && e._callback({
                                    name: e.name,
                                    type: "get",
                                    event: a
                                }), t
                            }), (function (t) {
                                return a.ax_status = 0, a.ax_size = 0, a.ax_duration = Date.now() - i, d(e._callback) && e._callback({
                                    name: e.name,
                                    type: "get",
                                    event: a
                                }), Promise.reject(t)
                            }))
                        }
                    }, this._getFetchUrl = function (t) {
                        var e = "";
                        return f(e = t instanceof Request ? t.url : t) ? e.split("?")[0] : e
                    }, this._getFetchMethod = function (t) {
                        var e = "get";
                        return t instanceof Request && (e = t.method), e
                    }, this._getFetchHeaders = function (e, n) {
                        var r = "";
                        if (e instanceof Request) return t._getAllResponseHeaders(e);
                        if (n && n.headers) {
                            if (n.headers instanceof Headers) return t._getAllResponseHeaders(n);
                            if (n.headers instanceof Array) return D(n.headers);
                            if (n.headers instanceof Object) {
                                var o = [];
                                for (var i in n.headers) Object.prototype.hasOwnProperty.call(n.headers, i) && o.push([i, n.headers[i]]);
                                return D(o)
                            }
                        }
                        return r
                    }, this._getAllResponseHeaders = function (t) {
                        if (!t || !t.headers || "function" != typeof t.headers.forEach) return "";
                        var e = [];
                        return t.headers.forEach((function (t, n) {
                            e.push(n + ": " + t)
                        })), e.join("\r\n")
                    }
                }, nt = [], rt = function () {
                    var t = this;
                    this.name = "StaticPerformanceMonitor", this.setup = function (e) {
                        w() && (t._callback = e, M((function () {
                            return t._sendPerformance()
                        })))
                    }, this._sendPerformance = function () {
                        if (w()) {
                            var e = t._getParams();
                            d(t._callback) && t._callback({name: t.name, event: e})
                        }
                    }, this._getParams = function () {
                        return {resources: t._getResources()}
                    }, this._getResources = function () {
                        return w() ? window.performance.getEntriesByType("resource").filter((function (t) {
                            return !j(nt, t.initiatorType)
                        })) : []
                    }
                }, ot = 0, it = ["ms", "moz", "webkit", "o"], at = function () {
                    for (var t = window.requestAnimationFrame, e = 0; e < it.length && !t; ++e) t = window[it[e] + "RequestAnimationFrame"];
                    return t || function (t) {
                        var e = (new Date).getTime(), n = Math.max(0, 16 - (e - ot)),
                            r = window.setTimeout((function () {
                                t(e + n)
                            }), n);
                        return ot = e + n, r
                    }
                }, st = function () {
                    for (var t = window.cancelAnimationFrame, e = 0; e < it.length && !t; ++e) t = window[it[e] + "CancelAnimationFrame"] || window[it[e] + "CancelRequestAnimationFrame"];
                    return t || function (t) {
                        clearTimeout(t)
                    }
                }, ct = function () {
                    var t = this;
                    this.name = "FirstScreenMonitor", this.setup = function (e) {
                        g() && (t._callback = e, t._start())
                    }, this._start = function () {
                        var e, n = at(), r = st(), o = !1,
                            i = (window.innerHeight ? window.innerHeight : document.documentElement && document.documentElement.clientHeight ? document.documentElement.clientHeight : 0) || 0,
                            a = [], s = !1, c = !1, u = t;

                        function l() {
                            var t, p;
                            if (s) {
                                if (a.length && !c) for (t = 0; t < a.length; t++) {
                                    if (!(p = a[t]).complete) {
                                        c = !1;
                                        break
                                    }
                                    c = !0
                                } else c = !0;
                                if (c) return o || (o = !0, d(u._callback) && u._callback({time: Date.now()})), void r(e)
                            } else {
                                var h = document.querySelectorAll("img");
                                for (t = 0; t < h.length; t++) {
                                    var f = ut(p = h[t]);
                                    if (i < f) {
                                        s = !0;
                                        break
                                    }
                                    f <= i && !p.hasPushed && (p.hasPushed = 1, a.push(p))
                                }
                            }
                            e = n(l)
                        }

                        if (e = n(l), "complete" === document.readyState) return s = c = !0, r(e), void l();
                        document.addEventListener("DOMContentLoaded", (function () {
                            document.querySelectorAll("img").length || (s = !0, r(e), l())
                        })), window.addEventListener("load", (function () {
                            s = c = !0, r(e), l()
                        }), !1)
                    }
                };

                function ut(t) {
                    if (!t) return 0;
                    var e = t.offsetTop;
                    return t.offsetParent && (e += ut(t.offsetParent)), e
                }

                var lt = function () {
                        var t = this;
                        this.name = "PerformanceMonitor", this.setup = function (e) {
                            b() && (t._callback = e, t._sendParams = {ev_type: "perf", has_resource: 0}, M((function () {
                                return t._perfLog()
                            })), (new rt).setup(t._hasResource), (new ct).setup(t._hasFirstScreen))
                        }, this._hasResource = function (e) {
                            t._sendParams = c(c(c({}, t._sendParams), e.event), {has_resource: 1})
                        }, this._hasFirstScreen = function (e) {
                            b() && (t._sendParams.firstscreen = e.time - window.performance.timing.navigationStart)
                        }, this._getParams = function () {
                            if (b()) {
                                var e = {}, n = window.performance.timing;
                                e.dns = n.domainLookupEnd - n.domainLookupStart, e.tcp = n.connectEnd - n.connectStart, e.request = n.responseStart - n.requestStart, e.response = n.responseEnd - n.responseStart, e.processing = n.domComplete - n.domLoading, e.blank = n.responseEnd - n.navigationStart, e.domready = n.domInteractive - n.navigationStart, e.load = n.loadEventEnd - n.navigationStart, n.secureConnectionStart && (e.ssl = n.connectEnd - n.secureConnectionStart), e.domparse = n.domInteractive - n.responseEnd, e.resource = n.loadEventStart - n.domContentLoadedEventEnd, e.ttfb = n.responseStart - n.requestStart, e.redirct = n.redirectEnd - n.redirectStart;
                                var r = t._getPaintTime("first-paint"), o = t._getPaintTime("first-contentful-paint");
                                return r && (e.fp = Math.round(r)), o && (e.fcp = Math.round(o)), e.navigation = function () {
                                    if (!w()) return window.performance.timing;
                                    var t = window.performance.getEntriesByType("navigation");
                                    return v(t) && 0 !== t.length ? t[0] : window.performance.timing
                                }(), e
                            }
                        }, this._getPaintTime = function (t) {
                            if (w()) {
                                var e = performance.getEntriesByType("paint");
                                if (v(e)) {
                                    var n = e.filter((function (e) {
                                        return e.name === t
                                    }));
                                    return 0 === n.length ? 0 : n[0].startTime
                                }
                            }
                            return 0
                        }, this._perfLog = function () {
                            setTimeout((function () {
                                b() && (t._sendParams = c(c({}, t._sendParams), t._getParams()), t._sendParams.firstscreen || (t._sendParams.firstscreen = t._sendParams.domready), d(t._callback) && t._callback({
                                    name: t.name,
                                    type: "post",
                                    event: t._sendParams
                                }))
                            }), 0)
                        }
                    }, pt = function () {
                        var t = this;
                        this.name = "PathMonitor", this.setup = function (e) {
                            g() && (t._callback = e, t._start())
                        }, this._start = function () {
                            t._monitorHashChange(), g() && h(window.history) && d(window.history.pushState) && d(window.history.replaceState) && (t._monitorPushState(), t._monitorReplaceState())
                        }, this._monitorHashChange = function () {
                            window.addEventListener("hashchange", (function () {
                                var e = t._parseHash(location.hash);
                                e && t._pathChangeHandler(t._getPath(e), "hash")
                            }))
                        }, this._monitorPushState = function () {
                            var e = t, n = window.history.pushState;
                            n && (window.history.pushState = function () {
                                for (var t = [], r = 0; r < arguments.length; r++) t[r] = arguments[r];
                                return e._handleHistoryStateChange.apply(e, p(t)), n.apply(this, t)
                            })
                        }, this._monitorReplaceState = function () {
                            var e = t, n = window.history.replaceState;
                            n && (window.history.replaceState = function () {
                                for (var t = [], r = 0; r < arguments.length; r++) t[r] = arguments[r];
                                return e._handleHistoryStateChange.apply(e, p(t)), n.apply(this, t)
                            })
                        }, this._pathChangeHandler = function (e, n) {
                            f(e) && d(t._callback) && t._callback({
                                name: t.name,
                                type: "get",
                                event: {ev_type: "pageview", path: e, type: n}
                            })
                        }, this._handleHistoryStateChange = function (e, n, r) {
                            var o = t._parseURL(r), i = t._parseURL(location.href);
                            o && i && (o.pathname === i.pathname ? o.hash === i.hash || t._pathChangeHandler(t._getPath(i.hash), "hash") : t._pathChangeHandler(t._getPath(o.pathname), "pathname"))
                        }, this._parseURL = function (t) {
                            if (!t) return null;
                            if ("string" != typeof t) return null;
                            if (t.match(/^\/[^\/]/)) return new URL(location.protocol + "//" + location.host + t);
                            try {
                                return new URL(t)
                            } catch (t) {
                                return null
                            }
                        }, this._parseHash = function (t) {
                            return t ? "string" != typeof t ? "" : t.replace(/^#/, "") : ""
                        }, this._getPath = function (e) {
                            var n = e && "string" == typeof e ? e.replace(/^(https?:)?\/\//, "").replace(/\?.*$/, "") : "";
                            return t._parseHash(n)
                        }
                    }, ht = A(["bytecdn.cn", "pstatp.com", "snssdk.com", "toutiao.com", "365yg.com", "byted.org"]),
                    dt = (ft.prototype._sendHijackEvent = function () {
                        d(this._callback) && this._callback({
                            name: this.name,
                            type: "post",
                            event: {ev_type: "hijack", events: this._events}
                        })
                    }, ft);

                function ft() {
                    var t = this;
                    this.name = "HijackMonitor", this.setup = function (e) {
                        g() && (t._callback = e, t._start())
                    }, this._start = function () {
                        M((function () {
                            setTimeout((function () {
                                t._antiHijack()
                            }), 2e3)
                        }))
                    }, this._antiHijack = function () {
                        t._checkScripts(), t._checkIframe(), t._sendHijackEvent()
                    }, this._checkScripts = function () {
                        for (var e = document.getElementsByTagName("script"), n = 0; n < e.length; n++) {
                            var r = e[n], o = R(r.src);
                            r.src ? t._inWhiteListDomain(o.hostname) || t._events.push({
                                hijack_type: "script",
                                hijack_host: o.host,
                                hijack_content: r.src
                            }) : t._inWhiteListContent(r.innerHTML) || t._events.push({
                                hijack_type: "script",
                                hijack_host: "unknown",
                                hijack_content: r.innerHTML
                            })
                        }
                    }, this._checkIframe = function () {
                        for (var e = document.getElementsByTagName("iframe"), n = 0, r = e.length; n < r; n++) {
                            var o = e[n], i = o.src, a = "about:blank";
                            if (i && i !== a) {
                                var s = R(i);
                                0 === s.protocol.indexOf("http") && s.hostname && t._inWhiteListIframeDomain(s.hostname) && t._events.push({
                                    hijack_type: "iframe",
                                    hijack_host: s.host,
                                    hijack_content: i
                                })
                            } else if (i === a) {
                                var c = "";
                                try {
                                    o.contentDocument && o.contentDocument.body && o.contentDocument.body.innerHTML && (c = o.contentDocument.body.innerHTML)
                                } catch (e) {
                                    c = "Access is denied"
                                }
                                c && t._events.push({hijack_type: "iframe", hijack_host: a, hijack_content: c})
                            }
                        }
                    }, this._inWhiteListDomain = function (t) {
                        return !(!ht || !ht.test(t))
                    }, this._inWhiteListContent = function (t) {
                        return !1
                    }, this._inWhiteListIframeDomain = function (e) {
                        return t._inWhiteListDomain(e)
                    }, this._events = []
                }

                var vt = Object.prototype.hasOwnProperty, _t = "~";

                function mt() {
                }

                function gt(t, e, n) {
                    this.fn = t, this.context = e, this.once = n || !1
                }

                function yt(t, e, n, r, o) {
                    if ("function" != typeof n) throw new TypeError("The listener must be a function");
                    var i = new gt(n, r || t, o), a = _t ? _t + e : e;
                    return t._events[a] ? t._events[a].fn ? t._events[a] = [t._events[a], i] : t._events[a].push(i) : (t._events[a] = i, t._eventsCount++), t
                }

                function bt(t, e) {
                    0 == --t._eventsCount ? t._events = new mt : delete t._events[e]
                }

                function wt() {
                    this._events = new mt, this._eventsCount = 0
                }

                Object.create && (mt.prototype = Object.create(null), (new mt).__proto__ || (_t = !1)), wt.prototype.eventNames = function () {
                    var t, e, n = [];
                    if (0 === this._eventsCount) return n;
                    for (e in t = this._events) vt.call(t, e) && n.push(_t ? e.slice(1) : e);
                    return Object.getOwnPropertySymbols ? n.concat(Object.getOwnPropertySymbols(t)) : n
                }, wt.prototype.listeners = function (t) {
                    var e = _t ? _t + t : t, n = this._events[e];
                    if (!n) return [];
                    if (n.fn) return [n.fn];
                    for (var r = 0, o = n.length, i = new Array(o); r < o; r++) i[r] = n[r].fn;
                    return i
                }, wt.prototype.listenerCount = function (t) {
                    var e = _t ? _t + t : t, n = this._events[e];
                    return n ? n.fn ? 1 : n.length : 0
                }, wt.prototype.emit = function (t, e, n, r, o, i) {
                    var a = _t ? _t + t : t;
                    if (!this._events[a]) return !1;
                    var s, c, u = this._events[a], l = arguments.length;
                    if (u.fn) {
                        switch (u.once && this.removeListener(t, u.fn, void 0, !0), l) {
                            case 1:
                                return u.fn.call(u.context), !0;
                            case 2:
                                return u.fn.call(u.context, e), !0;
                            case 3:
                                return u.fn.call(u.context, e, n), !0;
                            case 4:
                                return u.fn.call(u.context, e, n, r), !0;
                            case 5:
                                return u.fn.call(u.context, e, n, r, o), !0;
                            case 6:
                                return u.fn.call(u.context, e, n, r, o, i), !0
                        }
                        for (c = 1, s = new Array(l - 1); c < l; c++) s[c - 1] = arguments[c];
                        u.fn.apply(u.context, s)
                    } else {
                        var p, h = u.length;
                        for (c = 0; c < h; c++) switch (u[c].once && this.removeListener(t, u[c].fn, void 0, !0), l) {
                            case 1:
                                u[c].fn.call(u[c].context);
                                break;
                            case 2:
                                u[c].fn.call(u[c].context, e);
                                break;
                            case 3:
                                u[c].fn.call(u[c].context, e, n);
                                break;
                            case 4:
                                u[c].fn.call(u[c].context, e, n, r);
                                break;
                            default:
                                if (!s) for (p = 1, s = new Array(l - 1); p < l; p++) s[p - 1] = arguments[p];
                                u[c].fn.apply(u[c].context, s)
                        }
                    }
                    return !0
                }, wt.prototype.on = function (t, e, n) {
                    return yt(this, t, e, n, !1)
                }, wt.prototype.once = function (t, e, n) {
                    return yt(this, t, e, n, !0)
                }, wt.prototype.removeListener = function (t, e, n, r) {
                    var o = _t ? _t + t : t;
                    if (!this._events[o]) return this;
                    if (!e) return bt(this, o), this;
                    var i = this._events[o];
                    if (i.fn) i.fn !== e || r && !i.once || n && i.context !== n || bt(this, o); else {
                        for (var a = 0, s = [], c = i.length; a < c; a++) (i[a].fn !== e || r && !i[a].once || n && i[a].context !== n) && s.push(i[a]);
                        s.length ? this._events[o] = 1 === s.length ? s[0] : s : bt(this, o)
                    }
                    return this
                }, wt.prototype.removeAllListeners = function (t) {
                    var e;
                    return t ? (e = _t ? _t + t : t, this._events[e] && bt(this, e)) : (this._events = new mt, this._eventsCount = 0), this
                }, wt.prototype.off = wt.prototype.removeListener, wt.prototype.addListener = wt.prototype.on, wt.prefixed = _t;
                var Et = new (wt.EventEmitter = wt);

                function St(t) {
                    if (t && f(t) && g() && h(document) && d(document.createElement)) {
                        var e = document.createElement("script"), n = document.head;
                        h(e) && h(n) && (e.src = t, e.async = !0, e.crossorigin = "anonymous", d(n.appendChild) && n.appendChild(e))
                    }
                }

                var xt, kt, Tt, Ot, jt, Ct, Rt, Lt, Pt, Mt, Dt,
                    It = "https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/slardar/plugins/sentry.2.1.17.71e8145f.js",
                    Nt = "https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/slardar/plugins/behavior.2.1.17.ba349dc6.js",
                    At = function () {
                        var t, e = this;
                        this.version = "2.1.21", this._setBaseParams = function () {
                            e.baseParams.bid = e.shared.config.commonParams.bid || "", e.baseParams.pid = e.shared.config.commonParams.pid || ""
                        }, this.instance = function () {
                            for (var t, n, r = [], o = 0; o < arguments.length; o++) r[o] = arguments[o];
                            var i = r[0], a = r.slice(1);
                            if ("config" !== i) {
                                if (e._client) if ("send" !== i) if ("sendCustomCountLog" !== i) if ("sendCustomTimeLog" !== i) if ("precollect" !== i) if ("Sentry" !== i) {
                                    if ("emit" === i) {
                                        if (!r[1] || !r[2]) return;
                                        var s = {type: r[1], event: r[2]};
                                        e._client.emitEvent(s)
                                    }
                                } else {
                                    var c = r[1];
                                    d(c) && (e.shared.plugins && e.shared.plugins.sentry ? c(e.shared.plugins.sentry) : e.shared.collect && e.shared.collect.Sentry.push(a[0]))
                                } else {
                                    if (e.shared.instance && !e.shared.instance.length) return;
                                    if ("error" !== r[1]) return;
                                    if (!r[2] || !r[2][0]) return;
                                    var u = r[2][0] || {};
                                    "error" === u.type && (e.shared.monitors && e.shared.monitors.StaticErrorMonitor && d(e.shared.monitors.StaticErrorMonitor.staticErrorLog) && e.shared.monitors.StaticErrorMonitor.staticErrorLog(u), e._collectSentryEvent(u))
                                } else (n = e._client).sendCustomTimeLog.apply(n, p(a)); else (t = e._client).sendCustomCountLog.apply(t, p(a)); else e._send(a)
                            } else {
                                var l = r[1];
                                e._configSetting = l, e._configSetting && e._configSetting.onlyUseLocalSetting && (e._serverSetting = {});
                                var h = e._normalizeSetting(l);
                                e._client ? e._client.updateConfig(h) : e._init(h)
                            }
                        }, this._collectSentryEvent = function (t) {
                            e.shared.plugins && !e.shared.plugins.sentry && (t.error ? e.instance("Sentry", (function (e) {
                                e.captureException(t.error)
                            })) : t.message && e.instance("Sentry", (function (e) {
                                e.captureMessage(t.message)
                            })))
                        }, this._init = function (t) {
                            e.shared.monitors = {
                                StaticErrorMonitor: new K,
                                PerformanceMonitor: new lt,
                                PathMonitor: new pt,
                                HijackMonitor: new dt,
                                AjaxMonitor: new Q,
                                FetchMonitor: new et
                            };
                            var n = [e.shared.monitors.StaticErrorMonitor, e.shared.monitors.PerformanceMonitor, e.shared.monitors.PathMonitor, e.shared.monitors.HijackMonitor, e.shared.monitors.AjaxMonitor, e.shared.monitors.FetchMonitor],
                                r = c(c({}, t), {defaultMonitors: n});
                            e._client = new G(r), e.shared.instance && v(e.shared.instance) && e.shared.instance.push(r.commonParams.bid), e._getServerSetting(r.commonParams.bid), e._handlePrecollect()
                        }, this._handlePrecollect = function () {
                            d(window.removeEventListener) && window.Slardar && window.Slardar.globalPreCollectError && d(window.Slardar.globalPreCollectError) && window.removeEventListener("error", window.Slardar.globalPreCollectError, !0), d(window.addEventListener) && window.addEventListener("error", (function (t) {
                                e._collectSentryEvent(t)
                            }))
                        }, this._send = function (t) {
                            if ("count" === t[0]) {
                                var n = t[1], r = n.category, o = n.action;
                                e._client.sendCustomCountLog(r, o)
                            }
                            if ("timing" === t[0]) {
                                var i = t[1], a = (r = i.category, o = i.action, i.value);
                                e._client.sendCustomTimeLog(r, o, a)
                            }
                        }, this._getServerSetting = function (t) {
                            var n = e._serverSetting;
                            if (n) {
                                var r = e._normalizeSetting(n);
                                e._initServerSetting(r)
                            } else {
                                var o = "https://" + (e._baseClientConfig.commonParams.report_domain || F) + "/slardar/sdk_setting?bid=" + t;
                                X.get(o, {
                                    success: function (t) {
                                        try {
                                            var n = e._normalizeSetting(t.data);
                                            e._initServerSetting(n)
                                        } catch (t) {
                                            e._initServerSetting(e._baseClientConfig)
                                        }
                                    }, fail: function () {
                                        e._initServerSetting(e._baseClientConfig)
                                    }
                                })
                            }
                        }, this._initServerSetting = function (t) {
                            var n = e._normalizeSetting(t);
                            e._client.updateConfig(n), Math.random() < n.commonParams.sample_rate && (e._client.setupTransport(), e._client.sendPageview(), e.shared.transport = e._client._transport, e.shared.sendEvent = e._client.sendEvent), e._setCookie(n.commonParams.slardar_web_id), e.shared && "script" === e.shared.installedType && e._loadPlugins(t), e.shared && e.shared.emitter && e.shared.emitter.emit && d(e.shared.emitter.emit) && "npm" === e.shared.installedType && e.shared.emitter.emit("pluginsReady", n)
                        }, this._loadPlugins = function (t) {
                            var e = t.plugins;
                            e.sentry && e.sentry.enable && St(e.sentry.download_link || It), (e.behavior && e.behavior.enable || e.sentry && e.sentry.enable && e.sentry.behavior_enable) && St(e.behavior.download_link || Nt)
                        }, this._setCookie = function (t) {
                            t && (document.cookie = B + "=" + t + ";max-age=7776000;domain=" + location.hostname + ";path=/")
                        }, this._getSlardarWebId = function () {
                            var t = "";
                            return document && document.cookie && (t = N(document.cookie, B)), t
                        }, this._normalizeSetting = function (t) {
                            void 0 === t && (t = e._baseClientConfig);
                            var n = e._getClientCommonParams(t), r = e._getClientMonitorsSetting(t),
                                o = e._getClientPluginsSetting(t), i = e._getClientCustom(t),
                                a = T(e._baseClientConfig, {
                                    commonParams: n,
                                    plugins: o,
                                    monitors: r,
                                    custom: i
                                }, {
                                    commonParams: t.commonParams || {},
                                    plugins: t.plugins || {},
                                    monitors: t.monitors || {},
                                    custom: t.custom || {}
                                }, {
                                    commonParams: e._getClientCommonParams(e._configSetting),
                                    plugins: e._getClientPluginsSetting(e._configSetting),
                                    monitors: e._getClientMonitorsSetting(e._configSetting),
                                    custom: e._getClientCustom(e._configSetting)
                                });
                            return e.shared.config = a, e._setBaseParams(), e._baseClientConfig = a
                        }, this._getClientCommonParams = function (t) {
                            var e = {},
                                n = ["bid", "context", "pid", "sample_rate", "slardar_session_id", "slardar_web_id"];
                            return k(t, (function (t, r) {
                                j(n, t) && (e[t] = r)
                            })), t.cookieid && (e.slardar_web_id = t.cookieid), x(t, "sampleRate") && (e.sample_rate = t.sampleRate), t.reportDomain && (e.report_domain = t.reportDomain), t.domain && (e.report_domain = t.domain), e.slardar_web_id && (e.slardar_web_id = e.slardar_web_id.toString()), e
                        }, this._getClientCustom = function (t) {
                            var e = {};
                            return d(t.beforeSend) && (e.beforeSend = t.beforeSend), e
                        }, this._getClientMonitorsSetting = function (t) {
                            var n = c(c({}, e._baseClientConfig.monitors), t.monitors || {});
                            return t.ajaxWhitelistUrls && (n.AjaxMonitor = c(c({}, n.AjaxMonitor), {whitelistUrls: n.AjaxMonitor.whitelistUrls.concat(v(t.ajaxWhitelistUrls) ? t.ajaxWhitelistUrls : [])})), t.ignoreAjax && (n.AjaxMonitor = c(c({}, n.AjaxMonitor), {ignore: n.AjaxMonitor.ignore.concat(v(t.ignoreAjax) ? t.ignoreAjax : [])})), x(t, "hookFetch") && (n.AjaxMonitor = c(c({}, n.AjaxMonitor), {hookFetch: t.hookFetch})), x(t, "enableSizeStats") && (n.AjaxMonitor = c(c({}, n.AjaxMonitor), {hookFetch: t.hookFetch})), x(t, "geckoUrls") && (n.PerformanceMonitor = c(c({}, n.PerformanceMonitor || {}), {geckoUrls: t.geckoUrls})), t.ignoreStatic && (n.StaticErrorMonitor = c(c({}, n.StaticErrorMonitor), {ignore: n.StaticErrorMonitor.ignore.concat(v(t.ignoreStatic) ? t.ignoreStatic : [])})), n
                        }, this._getClientPluginsSetting = function (t) {
                            return t.plugins || {}
                        }, this._baseClientConfig = {
                            defaultMonitors: [],
                            commonParams: {
                                version: this.version,
                                hostname: window.location.hostname,
                                protocol: window.location.protocol.slice(0, -1),
                                url: window.location.href,
                                slardar_session_id: q,
                                sample_rate: 1,
                                pid: location.pathname,
                                report_domain: F,
                                screen_resolution: g() && window.screen && window.screen.width && window.screen.height ? window.screen.width + "x" + window.screen.height : "0x0",
                                network_type: (t = navigator.connection || navigator.mozConnection || navigator.webkitConnection) && f(t.effectiveType) ? t.effectiveType : "unknown",
                                bid: "",
                                context: {},
                                slardar_web_id: this._getSlardarWebId() || W
                            },
                            monitors: {
                                AjaxMonitor: {
                                    ignore: H,
                                    hookFetch: !0,
                                    enableSizeStats: !1,
                                    abort: !1,
                                    whitelistUrls: []
                                },
                                StaticErrorMonitor: {ignore: H},
                                PerformanceMonitor: {
                                    resourceSampleRate: .1,
                                    slowSessionTime: 8e3,
                                    geckoUrls: [],
                                    interval: 0,
                                    checkPoint: []
                                },
                                HijackMonitor: {sampleRate: .1}
                            },
                            plugins: {
                                spa: {enable: 0, type: ""},
                                behavior: {
                                    enable: 0,
                                    slardar_web_ids: [],
                                    sample_rate: 0,
                                    patterns: [],
                                    download_link: Nt
                                },
                                sentry: {
                                    enable: 0,
                                    behavior_enable: !1,
                                    behavior_sample_rate: 0,
                                    behavior_slardar_web_ids: [],
                                    download_link: It,
                                    tags: {}
                                }
                            },
                            custom: {
                                beforeSend: function (t) {
                                    return t
                                }
                            }
                        }, this._client = void 0, this._configSetting = {}, this.shared = {
                            config: this._baseClientConfig,
                            transport: this._client ? this._client._transport : void 0,
                            emitter: Et,
                            instance: [],
                            collect: {Sentry: [], staticError: []},
                            plugins: {},
                            monitors: {},
                            sendEvent: void 0
                        }, this.baseParams = {
                            bid: this.shared.config.commonParams.bid || "",
                            pid: this.shared.config.commonParams.pid || ""
                        }, this._serverSetting = this.__SLARDAR__REPALCE__HOLDER__
                    }, Ut = L;
                if (g()) {
                    var Ht = new At;
                    (Ut = Ht.instance).version = Ht.version, Ut.shared = Ht.shared, Ut.SlardarBrowser = At, Ut._baseParams = Ht.baseParams, window.Slardar && window.Slardar.shared && window.Slardar.shared.instance && window.Slardar.shared.instance.length ? Ut = window.Slardar : (window.Slardar && window.Slardar.q && (Ut.q = window.Slardar.q), window.Slardar && window.Slardar.globalPreCollectError && (Ut.globalPreCollectError = window.Slardar.globalPreCollectError), window.Slardar && window.Slardar.i && (Ut.i = window.Slardar.i), window.Slardar = Ut)
                }
                Ut.shared && (Ut.shared.installedType = "npm"), function () {
                    function e(t) {
                        return "function" == typeof t
                    }

                    function r() {
                        var t = setTimeout;
                        return function () {
                            return t(i, 1)
                        }
                    }

                    function i() {
                        for (var t = 0; t < S; t += 2) (0, P[t])(P[t + 1]), P[t] = void 0, P[t + 1] = void 0;
                        S = 0
                    }

                    function a(t, e) {
                        var n = this, r = new this.constructor(c);
                        void 0 === r[D] && m(r);
                        var o = n._state;
                        if (o) {
                            var i = arguments[o - 1];
                            T((function () {
                                return _(o, r, i, n._result)
                            }))
                        } else f(n, r, t, e);
                        return r
                    }

                    function s(t) {
                        if (t && "object" == o(t) && t.constructor === this) return t;
                        var e = new this(c);
                        return l(e, t), e
                    }

                    function c() {
                    }

                    function u(t, n, r) {
                        var o, i;
                        n.constructor === t.constructor && r === a && n.constructor.resolve === s ? (o = t, (i = n)._state === N ? h(o, i._result) : i._state === A ? d(o, i._result) : f(i, void 0, (function (t) {
                            return l(o, t)
                        }), (function (t) {
                            return d(o, t)
                        }))) : void 0 === r ? h(t, n) : e(r) ? function (t, e, n) {
                            T((function (t) {
                                var r = !1, o = function (t, e, n, r) {
                                    try {
                                        t.call(e, n, r)
                                    } catch (t) {
                                        return t
                                    }
                                }(n, e, (function (n) {
                                    r || (r = !0, e !== n ? l(t, n) : h(t, n))
                                }), (function (e) {
                                    r || (r = !0, d(t, e))
                                }), t._label);
                                !r && o && (r = !0, d(t, o))
                            }), t)
                        }(t, n, r) : h(t, n)
                    }

                    function l(t, e) {
                        if (t === e) d(t, new TypeError("You cannot resolve a promise with itself")); else if (i = o(r = e), null === r || "object" !== i && "function" !== i) h(t, e); else {
                            var n = void 0;
                            try {
                                n = e.then
                            } catch (e) {
                                return void d(t, e)
                            }
                            u(t, e, n)
                        }
                        var r, i
                    }

                    function p(t) {
                        t._onerror && t._onerror(t._result), v(t)
                    }

                    function h(t, e) {
                        t._state === I && (t._result = e, t._state = N, 0 !== t._subscribers.length && T(v, t))
                    }

                    function d(t, e) {
                        t._state === I && (t._state = A, t._result = e, T(p, t))
                    }

                    function f(t, e, n, r) {
                        var o = t._subscribers, i = o.length;
                        t._onerror = null, o[i] = e, o[i + N] = n, o[i + A] = r, 0 === i && t._state && T(v, t)
                    }

                    function v(t) {
                        var e = t._subscribers, n = t._state;
                        if (0 !== e.length) {
                            for (var r = void 0, o = void 0, i = t._result, a = 0; a < e.length; a += 3) r = e[a], o = e[a + n], r ? _(n, r, o, i) : o(i);
                            t._subscribers.length = 0
                        }
                    }

                    function _(t, n, r, o) {
                        var i = e(r), a = void 0, s = void 0, c = !0;
                        if (i) {
                            try {
                                a = r(o)
                            } catch (t) {
                                c = !1, s = t
                            }
                            if (n === a) return void d(n, new TypeError("A promises callback cannot return that same promise."))
                        } else a = o;
                        n._state !== I || (i && c ? l(n, a) : !1 === c ? d(n, s) : t === N ? h(n, a) : t === A && d(n, a))
                    }

                    function m(t) {
                        t[D] = U++, t._state = void 0, t._result = void 0, t._subscribers = []
                    }

                    var g, y, b, w, E = Array.isArray ? Array.isArray : function (t) {
                            return "[object Array]" === Object.prototype.toString.call(t)
                        }, S = 0, x = void 0, k = void 0, T = function (t, e) {
                            P[S] = t, P[S + 1] = e, 2 === (S += 2) && (k ? k(i) : M())
                        }, O = "undefined" != typeof window ? window : void 0, j = O || {},
                        C = j.MutationObserver || j.WebKitMutationObserver,
                        R = "undefined" == typeof self && void 0 !== t && "[object process]" === {}.toString.call(t),
                        L = "undefined" != typeof Uint8ClampedArray && "undefined" != typeof importScripts && "undefined" != typeof MessageChannel,
                        P = new Array(1e3), M = void 0;
                    M = R ? function () {
                        return t.nextTick(i)
                    } : C ? (y = 0, b = new C(i), w = document.createTextNode(""), b.observe(w, {characterData: !0}), function () {
                        w.data = y = ++y % 2
                    }) : L ? ((g = new MessageChannel).port1.onmessage = i, function () {
                        return g.port2.postMessage(0)
                    }) : void 0 === O ? function () {
                        try {
                            var t = Function("return this")().require("vertx");
                            return void 0 !== (x = t.runOnLoop || t.runOnContext) ? function () {
                                x(i)
                            } : r()
                        } catch (t) {
                            return r()
                        }
                    }() : r();
                    var D = Math.random().toString(36).substring(2), I = void 0, N = 1, A = 2, U = 0,
                        H = (q.prototype._enumerate = function (t) {
                            for (var e = 0; this._state === I && e < t.length; e++) this._eachEntry(t[e], e)
                        }, q.prototype._eachEntry = function (t, e) {
                            var n = this._instanceConstructor, r = n.resolve;
                            if (r === s) {
                                var o = void 0, i = void 0, l = !1;
                                try {
                                    o = t.then
                                } catch (e) {
                                    l = !0, i = e
                                }
                                if (o === a && t._state !== I) this._settledAt(t._state, e, t._result); else if ("function" != typeof o) this._remaining--, this._result[e] = t; else if (n === F) {
                                    var p = new n(c);
                                    l ? d(p, i) : u(p, t, o), this._willSettleAt(p, e)
                                } else this._willSettleAt(new n((function (e) {
                                    return e(t)
                                })), e)
                            } else this._willSettleAt(r(t), e)
                        }, q.prototype._settledAt = function (t, e, n) {
                            var r = this.promise;
                            r._state === I && (this._remaining--, t === A ? d(r, n) : this._result[e] = n), 0 === this._remaining && h(r, this._result)
                        }, q.prototype._willSettleAt = function (t, e) {
                            var n = this;
                            f(t, void 0, (function (t) {
                                return n._settledAt(N, e, t)
                            }), (function (t) {
                                return n._settledAt(A, e, t)
                            }))
                        }, q), F = (B.prototype.catch = function (t) {
                            return this.then(null, t)
                        }, B.prototype.finally = function (t) {
                            var n = this.constructor;
                            return e(t) ? this.then((function (e) {
                                return n.resolve(t()).then((function () {
                                    return e
                                }))
                            }), (function (e) {
                                return n.resolve(t()).then((function () {
                                    throw e
                                }))
                            })) : this.then(t, t)
                        }, B);

                    function B(t) {
                        this[D] = U++, this._result = this._state = void 0, this._subscribers = [], c !== t && ("function" != typeof t && function () {
                            throw new TypeError("You must pass a resolver function as the first argument to the promise constructor")
                        }(), this instanceof B ? function (t, e) {
                            try {
                                e((function (e) {
                                    l(t, e)
                                }), (function (e) {
                                    d(t, e)
                                }))
                            } catch (e) {
                                d(t, e)
                            }
                        }(this, t) : function () {
                            throw new TypeError("Failed to construct 'Promise': Please use the 'new' operator, this object constructor cannot be called as a function.")
                        }())
                    }

                    function q(t, e) {
                        this._instanceConstructor = t, this.promise = new t(c), this.promise[D] || m(this.promise), E(e) ? (this.length = e.length, this._remaining = e.length, this._result = new Array(this.length), 0 === this.length ? h(this.promise, this._result) : (this.length = this.length || 0, this._enumerate(e), 0 === this._remaining && h(this.promise, this._result))) : d(this.promise, new Error("Array Methods must be provided an Array"))
                    }

                    F.prototype.then = a, F.all = function (t) {
                        return new H(this, t).promise
                    }, F.race = function (t) {
                        var e = this;
                        return new e(E(t) ? function (n, r) {
                            for (var o = t.length, i = 0; i < o; i++) e.resolve(t[i]).then(n, r)
                        } : function (t, e) {
                            return e(new TypeError("You must pass an array to race."))
                        })
                    }, F.resolve = s, F.reject = function (t) {
                        var e = new this(c);
                        return d(e, t), e
                    }, F._setScheduler = function (t) {
                        k = t
                    }, F._setAsap = function (t) {
                        T = t
                    }, F._asap = T, F.polyfill = function () {
                        var t = void 0;
                        if (void 0 !== n) t = n; else if ("undefined" != typeof self) t = self; else try {
                            t = Function("return this")()
                        } catch (t) {
                            throw new Error("polyfill failed because global object is unavailable in this environment")
                        }
                        var e = t.Promise;
                        if (e) {
                            var r = null;
                            try {
                                r = Object.prototype.toString.call(e.resolve())
                            } catch (t) {
                            }
                            if ("[object Promise]" === r && !e.cast) return
                        }
                        t.Promise = F
                    }, (F.Promise = F).polyfill()
                }(), "function" != typeof Object.assign && Object.defineProperty(Object, "assign", {
                    value: function (t, e) {
                        if (null == t) throw new TypeError("Cannot convert undefined or null to object");
                        for (var n = Object(t), r = 1; r < arguments.length; r++) {
                            var o = arguments[r];
                            if (null != o) for (var i in o) Object.prototype.hasOwnProperty.call(o, i) && (n[i] = o[i])
                        }
                        return n
                    }, writable: !0, configurable: !0
                }), Number.isNaN = Number.isNaN || function (t) {
                    return t != t
                }, String.prototype.includes || (String.prototype.includes = function (t, e) {
                    return "number" != typeof e && (e = 0), !(e + t.length > this.length) && -1 !== this.indexOf(t, e)
                }), (kt = xt = xt || {})[kt.None = 0] = "None", kt[kt.Error = 1] = "Error", kt[kt.Debug = 2] = "Debug", kt[kt.Verbose = 3] = "Verbose", (Ot = Tt = Tt || {}).Fatal = "fatal", Ot.Error = "error", Ot.Warning = "warning", Ot.Log = "log", Ot.Info = "info", Ot.Debug = "debug", Ot.Critical = "critical", (jt = Tt = Tt || {}).fromString = function (t) {
                    switch (t) {
                        case"debug":
                            return jt.Debug;
                        case"info":
                            return jt.Info;
                        case"warn":
                        case"warning":
                            return jt.Warning;
                        case"error":
                            return jt.Error;
                        case"fatal":
                            return jt.Fatal;
                        case"critical":
                            return jt.Critical;
                        case"log":
                        default:
                            return jt.Log
                    }
                }, (Rt = Ct = Ct || {}).Ok = "ok", Rt.DealineExceeded = "deadline_exceeded", Rt.Unauthenticated = "unauthenticated", Rt.PermissionDenied = "permission_denied", Rt.NotFound = "not_found", Rt.ResourceExhausted = "resource_exhausted", Rt.InvalidArgument = "invalid_argument", Rt.Unimplemented = "unimplemented", Rt.Unavailable = "unavailable", Rt.InternalError = "internal_error", Rt.UnknownError = "unknown_error", Rt.Cancelled = "cancelled", Rt.AlreadyExists = "already_exists", Rt.FailedPrecondition = "failed_precondition", Rt.Aborted = "aborted", Rt.OutOfRange = "out_of_range", Rt.DataLoss = "data_loss", (Lt = Ct = Ct || {}).fromHttpCode = function (t) {
                    if (t < 400) return Lt.Ok;
                    if (400 <= t && t < 500) switch (t) {
                        case 401:
                            return Lt.Unauthenticated;
                        case 403:
                            return Lt.PermissionDenied;
                        case 404:
                            return Lt.NotFound;
                        case 409:
                            return Lt.AlreadyExists;
                        case 413:
                            return Lt.FailedPrecondition;
                        case 429:
                            return Lt.ResourceExhausted;
                        default:
                            return Lt.InvalidArgument
                    }
                    if (500 <= t && t < 600) switch (t) {
                        case 501:
                            return Lt.Unimplemented;
                        case 503:
                            return Lt.Unavailable;
                        case 504:
                            return Lt.DealineExceeded;
                        default:
                            return Lt.InternalError
                    }
                    return Lt.UnknownError
                }, (Mt = Pt = Pt || {}).Unknown = "unknown", Mt.Skipped = "skipped", Mt.Success = "success", Mt.RateLimit = "rate_limit", Mt.Invalid = "invalid", Mt.Failed = "failed", (Dt = Pt = Pt || {}).fromHttpCode = function (t) {
                    return 200 <= t && t < 300 ? Dt.Success : 429 === t ? Dt.RateLimit : 400 <= t && t < 500 ? Dt.Invalid : 500 <= t ? Dt.Failed : Dt.Unknown
                };
                var Ft, Bt = Object.setPrototypeOf || ({__proto__: []} instanceof Array ? function (t, e) {
                    return t.__proto__ = e, t
                } : function (t, e) {
                    for (var n in e) t.hasOwnProperty(n) || (t[n] = e[n]);
                    return t
                }), qt = (s(Wt, Ft = Error), Wt);

                function Wt(t) {
                    var e = this.constructor, n = Ft.call(this, t) || this;
                    return n.message = t, n.name = e.prototype.constructor.name, Bt(n, e.prototype), n
                }

                function Xt(t) {
                    switch (Object.prototype.toString.call(t)) {
                        case"[object Error]":
                        case"[object Exception]":
                        case"[object DOMException]":
                            return !0;
                        default:
                            return Zt(t, Error)
                    }
                }

                function Yt(t) {
                    return "[object ErrorEvent]" === Object.prototype.toString.call(t)
                }

                function zt(t) {
                    return "[object DOMError]" === Object.prototype.toString.call(t)
                }

                function Vt(t) {
                    return "[object String]" === Object.prototype.toString.call(t)
                }

                function Jt(t) {
                    return null === t || "object" !== o(t) && "function" != typeof t
                }

                function Gt(t) {
                    return "[object Object]" === Object.prototype.toString.call(t)
                }

                function $t(t) {
                    return "undefined" != typeof Event && Zt(t, Event)
                }

                function Kt(t) {
                    return "undefined" != typeof Element && Zt(t, Element)
                }

                function Qt(t) {
                    return Boolean(t && t.then && "function" == typeof t.then)
                }

                function Zt(t, e) {
                    try {
                        return t instanceof e
                    } catch (t) {
                        return !1
                    }
                }

                function te() {
                    return "[object process]" === Object.prototype.toString.call(void 0 !== t ? t : 0)
                }

                var ee = {};

                function ne() {
                    return te() ? n : "undefined" != typeof window ? window : "undefined" != typeof self ? self : ee
                }

                function re() {
                    var t = ne(), e = t.crypto || t.msCrypto;
                    if (void 0 !== e && e.getRandomValues) {
                        var n = new Uint16Array(8);
                        e.getRandomValues(n), n[3] = 4095 & n[3] | 16384, n[4] = 16383 & n[4] | 32768;
                        var r = function (t) {
                            for (var e = t.toString(16); e.length < 4;) e = "0" + e;
                            return e
                        };
                        return r(n[0]) + r(n[1]) + r(n[2]) + r(n[3]) + r(n[4]) + r(n[5]) + r(n[6]) + r(n[7])
                    }
                    return "xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx".replace(/[xy]/g, (function (t) {
                        var e = 16 * Math.random() | 0;
                        return ("x" === t ? e : 3 & e | 8).toString(16)
                    }))
                }

                function oe(t) {
                    if (!t) return {};
                    var e = t.match(/^(([^:\/?#]+):)?(\/\/([^\/?#]*))?([^?#]*)(\?([^#]*))?(#(.*))?$/);
                    if (!e) return {};
                    var n = e[6] || "", r = e[8] || "";
                    return {host: e[4], path: e[5], protocol: e[2], relative: e[5] + n + r}
                }

                function ie(t) {
                    if (t.message) return t.message;
                    if (t.exception && t.exception.values && t.exception.values[0]) {
                        var e = t.exception.values[0];
                        return e.type && e.value ? e.type + ": " + e.value : e.type || e.value || t.event_id || "<unknown>"
                    }
                    return t.event_id || "<unknown>"
                }

                function ae(t) {
                    var e = ne();
                    if (!("console" in e)) return t();
                    var n = e.console, r = {};
                    ["debug", "info", "warn", "error", "log", "assert"].forEach((function (t) {
                        t in e.console && n[t].__sentry_original__ && (r[t] = n[t], n[t] = n[t].__sentry_original__)
                    }));
                    var o = t();
                    return Object.keys(r).forEach((function (t) {
                        n[t] = r[t]
                    })), o
                }

                function se(t, e, n) {
                    t.exception = t.exception || {}, t.exception.values = t.exception.values || [], t.exception.values[0] = t.exception.values[0] || {}, t.exception.values[0].value = t.exception.values[0].value || e || "", t.exception.values[0].type = t.exception.values[0].type || n || "Error"
                }

                function ce(t, e) {
                    void 0 === e && (e = {});
                    try {
                        t.exception.values[0].mechanism = t.exception.values[0].mechanism || {}, Object.keys(e).forEach((function (n) {
                            t.exception.values[0].mechanism[n] = e[n]
                        }))
                    } catch (t) {
                    }
                }

                function ue(t) {
                    try {
                        for (var e = t, n = [], r = 0, o = 0, i = " > ".length, a = void 0; e && r++ < 5 && !("html" === (a = le(e)) || 1 < r && 80 <= o + n.length * i + a.length);) n.push(a), o += a.length, e = e.parentNode;
                        return n.reverse().join(" > ")
                    } catch (t) {
                        return "<unknown>"
                    }
                }

                function le(t) {
                    var e, n, r, o, i, a = t, s = [];
                    if (!a || !a.tagName) return "";
                    if (s.push(a.tagName.toLowerCase()), a.id && s.push("#" + a.id), (e = a.className) && Vt(e)) for (n = e.split(/\s+/), i = 0; i < n.length; i++) s.push("." + n[i]);
                    var c = ["type", "name", "title", "alt"];
                    for (i = 0; i < c.length; i++) r = c[i], (o = a.getAttribute(r)) && s.push("[" + r + '="' + o + '"]');
                    return s.join("")
                }

                function pe() {
                    return (new Date).getTime() / 1e3
                }

                function he(t, e) {
                    if (!e) return 6e4;
                    var n = parseInt("" + e, 10);
                    if (!isNaN(n)) return 1e3 * n;
                    var r = Date.parse("" + e);
                    return isNaN(r) ? 6e4 : r - t
                }

                var de = "<anonymous>";

                function fe(t) {
                    try {
                        return t && "function" == typeof t && t.name || de
                    } catch (t) {
                        return de
                    }
                }

                var ve = ne(), _e = "Sentry Logger ", me = (ge.prototype.disable = function () {
                    this._enabled = !1
                }, ge.prototype.enable = function () {
                    this._enabled = !0
                }, ge.prototype.log = function () {
                    for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
                    this._enabled && ae((function () {
                        ve.console.log(_e + "[Log]: " + t.join(" "))
                    }))
                }, ge.prototype.warn = function () {
                    for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
                    this._enabled && ae((function () {
                        ve.console.warn(_e + "[Warn]: " + t.join(" "))
                    }))
                }, ge.prototype.error = function () {
                    for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
                    this._enabled && ae((function () {
                        ve.console.error(_e + "[Error]: " + t.join(" "))
                    }))
                }, ge);

                function ge() {
                    this._enabled = !1
                }

                ve.__SENTRY__ = ve.__SENTRY__ || {};
                var ye, be, we = ve.__SENTRY__.logger || (ve.__SENTRY__.logger = new me),
                    Ee = (Se.prototype.memoize = function (t) {
                        if (this._hasWeakSet) return !!this._inner.has(t) || (this._inner.add(t), !1);
                        for (var e = 0; e < this._inner.length; e++) if (this._inner[e] === t) return !0;
                        return this._inner.push(t), !1
                    }, Se.prototype.unmemoize = function (t) {
                        if (this._hasWeakSet) this._inner.delete(t); else for (var e = 0; e < this._inner.length; e++) if (this._inner[e] === t) {
                            this._inner.splice(e, 1);
                            break
                        }
                    }, Se);

                function Se() {
                    this._hasWeakSet = "function" == typeof WeakSet, this._inner = this._hasWeakSet ? new WeakSet : []
                }

                function xe(t, e) {
                    return void 0 === e && (e = 0), "string" != typeof t || 0 === e ? t : t.length <= e ? t : t.substr(0, e) + "..."
                }

                function ke(t, e) {
                    if (!Array.isArray(t)) return "";
                    for (var n = [], r = 0; r < t.length; r++) {
                        var o = t[r];
                        try {
                            n.push(String(o))
                        } catch (t) {
                            n.push("[value cannot be serialized]")
                        }
                    }
                    return n.join(e)
                }

                function Te(t, e) {
                    return n = e, "[object RegExp]" === Object.prototype.toString.call(n) ? e.test(t) : "string" == typeof e && -1 !== t.indexOf(e);
                    var n
                }

                function Oe(t, e, n) {
                    if (e in t) {
                        var r = t[e], o = n(r);
                        if ("function" == typeof o) try {
                            o.prototype = o.prototype || {}, Object.defineProperties(o, {
                                __sentry_original__: {
                                    enumerable: !1,
                                    value: r
                                }
                            })
                        } catch (t) {
                        }
                        t[e] = o
                    }
                }

                function je(t) {
                    if (Xt(t)) {
                        var e = t, n = {message: e.message, name: e.name, stack: e.stack};
                        for (var r in e) Object.prototype.hasOwnProperty.call(e, r) && (n[r] = e[r]);
                        return n
                    }
                    if ($t(t)) {
                        var o = t, i = {};
                        i.type = o.type;
                        try {
                            i.target = Kt(o.target) ? ue(o.target) : Object.prototype.toString.call(o.target)
                        } catch (t) {
                            i.target = "<unknown>"
                        }
                        try {
                            i.currentTarget = Kt(o.currentTarget) ? ue(o.currentTarget) : Object.prototype.toString.call(o.currentTarget)
                        } catch (t) {
                            i.currentTarget = "<unknown>"
                        }
                        for (var r in "undefined" != typeof CustomEvent && Zt(t, CustomEvent) && (i.detail = o.detail), o) Object.prototype.hasOwnProperty.call(o, r) && (i[r] = o);
                        return i
                    }
                    return t
                }

                function Ce(t, e) {
                    return "domain" === e && t && "object" === o(t) && t._events ? "[Domain]" : "domainEmitter" === e ? "[DomainEmitter]" : void 0 !== n && t === n ? "[Global]" : "undefined" != typeof window && t === window ? "[Window]" : "undefined" != typeof document && t === document ? "[Document]" : Gt(r = t) && "nativeEvent" in r && "preventDefault" in r && "stopPropagation" in r ? "[SyntheticEvent]" : "number" == typeof t && t != t ? "[NaN]" : void 0 === t ? "[undefined]" : "function" == typeof t ? "[Function: " + fe(t) + "]" : t;
                    var r
                }

                function Re(t, e) {
                    try {
                        return JSON.parse(JSON.stringify(t, (function (t, n) {
                            return function t(e, n, r, o) {
                                if (void 0 === r && (r = 1 / 0), void 0 === o && (o = new Ee), 0 === r) return function (t) {
                                    var e = Object.prototype.toString.call(t);
                                    if ("string" == typeof t) return t;
                                    if ("[object Object]" === e) return "[Object]";
                                    if ("[object Array]" === e) return "[Array]";
                                    var n = Ce(t);
                                    return Jt(n) ? n : e
                                }(n);
                                if (null != n && "function" == typeof n.toJSON) return n.toJSON();
                                var i = Ce(n, e);
                                if (Jt(i)) return i;
                                var a = je(n), s = Array.isArray(n) ? [] : {};
                                if (o.memoize(n)) return "[Circular ~]";
                                for (var c in a) Object.prototype.hasOwnProperty.call(a, c) && (s[c] = t(c, a[c], r - 1, o));
                                return o.unmemoize(n), s
                            }(t, n, e)
                        })))
                    } catch (t) {
                        return "**non-serializable**"
                    }
                }

                (be = ye = ye || {}).PENDING = "PENDING", be.RESOLVED = "RESOLVED", be.REJECTED = "REJECTED";
                var Le = (Pe.prototype.toString = function () {
                    return "[object SyncPromise]"
                }, Pe.resolve = function (t) {
                    return new Pe((function (e) {
                        e(t)
                    }))
                }, Pe.reject = function (t) {
                    return new Pe((function (e, n) {
                        n(t)
                    }))
                }, Pe.all = function (t) {
                    return new Pe((function (e, n) {
                        if (Array.isArray(t)) if (0 !== t.length) {
                            var r = t.length, o = [];
                            t.forEach((function (t, i) {
                                Pe.resolve(t).then((function (t) {
                                    o[i] = t, 0 == --r && e(o)
                                })).then(null, n)
                            }))
                        } else e([]); else n(new TypeError("Promise.all requires an array as input."))
                    }))
                }, Pe.prototype.then = function (t, e) {
                    var n = this;
                    return new Pe((function (r, o) {
                        n._attachHandler({
                            onfulfilled: function (e) {
                                if (t) try {
                                    return void r(t(e))
                                } catch (e) {
                                    return void o(e)
                                } else r(e)
                            }, onrejected: function (t) {
                                if (e) try {
                                    return void r(e(t))
                                } catch (t) {
                                    return void o(t)
                                } else o(t)
                            }
                        })
                    }))
                }, Pe.prototype.catch = function (t) {
                    return this.then((function (t) {
                        return t
                    }), t)
                }, Pe.prototype.finally = function (t) {
                    var e = this;
                    return new Pe((function (n, r) {
                        var o, i;
                        return e.then((function (e) {
                            i = !1, o = e, t && t()
                        }), (function (e) {
                            i = !0, o = e, t && t()
                        })).then((function () {
                            i ? r(o) : n(o)
                        }))
                    }))
                }, Pe);

                function Pe(t) {
                    var e = this;
                    this._state = ye.PENDING, this._handlers = [], this._resolve = function (t) {
                        e._setResult(ye.RESOLVED, t)
                    }, this._reject = function (t) {
                        e._setResult(ye.REJECTED, t)
                    }, this._setResult = function (t, n) {
                        e._state === ye.PENDING && (Qt(n) ? n.then(e._resolve, e._reject) : (e._state = t, e._value = n, e._executeHandlers()))
                    }, this._attachHandler = function (t) {
                        e._handlers = e._handlers.concat(t), e._executeHandlers()
                    }, this._executeHandlers = function () {
                        e._state !== ye.PENDING && (e._state === ye.REJECTED ? e._handlers.forEach((function (t) {
                            t.onrejected && t.onrejected(e._value)
                        })) : e._handlers.forEach((function (t) {
                            t.onfulfilled && t.onfulfilled(e._value)
                        })), e._handlers = [])
                    };
                    try {
                        t(this._resolve, this._reject)
                    } catch (t) {
                        this._reject(t)
                    }
                }

                var Me = (De.prototype.isReady = function () {
                    return void 0 === this._limit || this.length() < this._limit
                }, De.prototype.add = function (t) {
                    var e = this;
                    return this.isReady() ? (-1 === this._buffer.indexOf(t) && this._buffer.push(t), t.then((function () {
                        return e.remove(t)
                    })).then(null, (function () {
                        return e.remove(t).then(null, (function () {
                        }))
                    })), t) : Le.reject(new qt("Not adding Promise due to buffer limit reached."))
                }, De.prototype.remove = function (t) {
                    return this._buffer.splice(this._buffer.indexOf(t), 1)[0]
                }, De.prototype.length = function () {
                    return this._buffer.length
                }, De.prototype.drain = function (t) {
                    var e = this;
                    return new Le((function (n) {
                        var r = setTimeout((function () {
                            t && 0 < t && n(!1)
                        }), t);
                        Le.all(e._buffer).then((function () {
                            clearTimeout(r), n(!0)
                        })).then(null, (function () {
                            n(!0)
                        }))
                    }))
                }, De);

                function De(t) {
                    this._limit = t, this._buffer = []
                }

                function Ie() {
                    if (!("fetch" in ne())) return !1;
                    try {
                        return new Headers, new Request(""), new Response, !0
                    } catch (t) {
                        return !1
                    }
                }

                function Ne(t) {
                    return t && /^function fetch\(\)\s+\{\s+\[native code\]\s+\}$/.test(t.toString())
                }

                var Ae, Ue = ne(), He = {}, Fe = {};

                function Be(t) {
                    t && "string" == typeof t.type && "function" == typeof t.callback && (He[t.type] = He[t.type] || [], He[t.type].push(t.callback), function (t) {
                        if (!Fe[t]) switch (Fe[t] = !0, t) {
                            case"console":
                                "console" in Ue && ["debug", "info", "warn", "error", "log", "assert"].forEach((function (t) {
                                    t in Ue.console && Oe(Ue.console, t, (function (e) {
                                        return function () {
                                            for (var n = [], r = 0; r < arguments.length; r++) n[r] = arguments[r];
                                            qe("console", {
                                                args: n,
                                                level: t
                                            }), e && Function.prototype.apply.call(e, Ue.console, n)
                                        }
                                    }))
                                }));
                                break;
                            case"dom":
                                "document" in Ue && (Ue.document.addEventListener("click", ze("click", qe.bind(null, "dom")), !1), Ue.document.addEventListener("keypress", Ve(qe.bind(null, "dom")), !1), ["EventTarget", "Node"].forEach((function (t) {
                                    var e = Ue[t] && Ue[t].prototype;
                                    e && e.hasOwnProperty && e.hasOwnProperty("addEventListener") && (Oe(e, "addEventListener", (function (t) {
                                        return function (e, n, r) {
                                            return n && n.handleEvent ? ("click" === e && Oe(n, "handleEvent", (function (t) {
                                                return function (e) {
                                                    return ze("click", qe.bind(null, "dom"))(e), t.call(this, e)
                                                }
                                            })), "keypress" === e && Oe(n, "handleEvent", (function (t) {
                                                return function (e) {
                                                    return Ve(qe.bind(null, "dom"))(e), t.call(this, e)
                                                }
                                            }))) : ("click" === e && ze("click", qe.bind(null, "dom"), !0)(this), "keypress" === e && Ve(qe.bind(null, "dom"))(this)), t.call(this, e, n, r)
                                        }
                                    })), Oe(e, "removeEventListener", (function (t) {
                                        return function (e, n, r) {
                                            var o = n;
                                            try {
                                                o = o && (o.__sentry_wrapped__ || o)
                                            } catch (e) {
                                            }
                                            return t.call(this, e, o, r)
                                        }
                                    })))
                                })));
                                break;
                            case"xhr":
                                !function () {
                                    if ("XMLHttpRequest" in Ue) {
                                        var t = XMLHttpRequest.prototype;
                                        Oe(t, "open", (function (t) {
                                            return function () {
                                                for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                                                var r = e[1];
                                                return this.__sentry_xhr__ = {
                                                    method: Vt(e[0]) ? e[0].toUpperCase() : e[0],
                                                    url: e[1]
                                                }, Vt(r) && "POST" === this.__sentry_xhr__.method && r.match(/sentry_key/) && (this.__sentry_own_request__ = !0), t.apply(this, e)
                                            }
                                        })), Oe(t, "send", (function (t) {
                                            return function () {
                                                for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                                                var r = this, o = {args: e, startTimestamp: Date.now(), xhr: r};

                                                function i() {
                                                    if (4 === r.readyState) {
                                                        try {
                                                            r.__sentry_xhr__ && (r.__sentry_xhr__.status_code = r.status)
                                                        } catch (t) {
                                                        }
                                                        qe("xhr", c({}, o, {endTimestamp: Date.now()}))
                                                    }
                                                }

                                                return qe("xhr", c({}, o)), "onreadystatechange" in r && "function" == typeof r.onreadystatechange ? Oe(r, "onreadystatechange", (function (t) {
                                                    return function () {
                                                        for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                                                        return i(), t.apply(r, e)
                                                    }
                                                })) : r.onreadystatechange = i, t.apply(this, e)
                                            }
                                        }))
                                    }
                                }();
                                break;
                            case"fetch":
                                (function () {
                                    if (!Ie()) return !1;
                                    var t = ne();
                                    if (Ne(t.fetch)) return !0;
                                    var e = !1, n = t.document;
                                    if (n) {
                                        var r = n.createElement("iframe");
                                        r.hidden = !0;
                                        try {
                                            n.head.appendChild(r), r.contentWindow && r.contentWindow.fetch && (e = Ne(r.contentWindow.fetch)), n.head.removeChild(r)
                                        } catch (t) {
                                            we.warn("Could not create sandbox iframe for pure fetch check, bailing to window.fetch: ", t)
                                        }
                                    }
                                    return e
                                })() && Oe(Ue, "fetch", (function (t) {
                                    return function () {
                                        for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                                        var r = {
                                            args: e, fetchData: {
                                                method: function (t) {
                                                    return void 0 === t && (t = []), "Request" in Ue && Zt(t[0], Request) && t[0].method ? String(t[0].method).toUpperCase() : t[1] && t[1].method ? String(t[1].method).toUpperCase() : "GET"
                                                }(e), url: function (t) {
                                                    return void 0 === t && (t = []), "string" == typeof t[0] ? t[0] : "Request" in Ue && Zt(t[0], Request) ? t[0].url : String(t[0])
                                                }(e)
                                            }, startTimestamp: Date.now()
                                        };
                                        return qe("fetch", c({}, r)), t.apply(Ue, e).then((function (t) {
                                            return qe("fetch", c({}, r, {endTimestamp: Date.now(), response: t})), t
                                        }), (function (t) {
                                            throw qe("fetch", c({}, r, {endTimestamp: Date.now(), error: t})), t
                                        }))
                                    }
                                }));
                                break;
                            case"history":
                                !function () {
                                    if (function () {
                                        var t = ne(), e = t.chrome, n = e && e.app && e.app.runtime,
                                            r = "history" in t && !!t.history.pushState && !!t.history.replaceState;
                                        return !n && r
                                    }()) {
                                        var t = Ue.onpopstate;
                                        Ue.onpopstate = function () {
                                            for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                                            var r = Ue.location.href;
                                            if (qe("history", {from: Ae, to: Ae = r}), t) return t.apply(this, e)
                                        }, Oe(Ue.history, "pushState", e), Oe(Ue.history, "replaceState", e)
                                    }

                                    function e(t) {
                                        return function () {
                                            for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                                            var r = 2 < e.length ? e[2] : void 0;
                                            if (r) {
                                                var o = Ae, i = String(r);
                                                qe("history", {from: o, to: Ae = i})
                                            }
                                            return t.apply(this, e)
                                        }
                                    }
                                }();
                                break;
                            default:
                                we.warn("unknown instrumentation type:", t)
                        }
                    }(t.type))
                }

                function qe(t, e) {
                    var n, r;
                    if (t && He[t]) try {
                        for (var o = u(He[t] || []), i = o.next(); !i.done; i = o.next()) {
                            var a = i.value;
                            try {
                                a(e)
                            } catch (e) {
                                we.error("Error while triggering instrumentation handler.\nType: " + t + "\nName: " + fe(a) + "\nError: " + e)
                            }
                        }
                    } catch (e) {
                        n = {error: e}
                    } finally {
                        try {
                            i && !i.done && (r = o.return) && r.call(o)
                        } finally {
                            if (n) throw n.error
                        }
                    }
                }

                var We, Xe, Ye = 0;

                function ze(t, e, n) {
                    return void 0 === n && (n = !1), function (r) {
                        We = void 0, r && Xe !== r && (Xe = r, Ye && clearTimeout(Ye), n ? Ye = setTimeout((function () {
                            e({event: r, name: t})
                        })) : e({event: r, name: t}))
                    }
                }

                function Ve(t) {
                    return function (e) {
                        var n;
                        try {
                            n = e.target
                        } catch (e) {
                            return
                        }
                        var r = n && n.tagName;
                        r && ("INPUT" === r || "TEXTAREA" === r || n.isContentEditable) && (We || ze("input", t)(e), clearTimeout(We), We = setTimeout((function () {
                            We = void 0
                        }), 1e3))
                    }
                }

                var Je = /^(?:(\w+):)\/\/(?:(\w+)(?::(\w+))?@)([\w\.-]+)(?::(\d+))?\/(.+)/, Ge = "Invalid Dsn",
                    $e = (Ke.prototype.toString = function (t) {
                        void 0 === t && (t = !1);
                        var e = this, n = e.host, r = e.path, o = e.pass, i = e.port, a = e.projectId;
                        return e.protocol + "://" + e.user + (t && o ? ":" + o : "") + "@" + n + (i ? ":" + i : "") + "/" + (r ? r + "/" : r) + a
                    }, Ke.prototype._fromString = function (t) {
                        var e = Je.exec(t);
                        if (!e) throw new qt(Ge);
                        var n = l(e.slice(1), 6), r = n[0], o = n[1], i = n[2], a = void 0 === i ? "" : i, s = n[3],
                            c = n[4], u = void 0 === c ? "" : c, p = "", h = n[5], d = h.split("/");
                        1 < d.length && (p = d.slice(0, -1).join("/"), h = d.pop()), this._fromComponents({
                            host: s,
                            pass: a,
                            path: p,
                            projectId: h,
                            port: u,
                            protocol: r,
                            user: o
                        })
                    }, Ke.prototype._fromComponents = function (t) {
                        this.protocol = t.protocol, this.user = t.user, this.pass = t.pass || "", this.host = t.host, this.port = t.port || "", this.path = t.path || "", this.projectId = t.projectId
                    }, Ke.prototype._validate = function () {
                        var t = this;
                        if (["protocol", "user", "host", "projectId"].forEach((function (e) {
                            if (!t[e]) throw new qt(Ge)
                        })), "http" !== this.protocol && "https" !== this.protocol) throw new qt(Ge);
                        if (this.port && isNaN(parseInt(this.port, 10))) throw new qt(Ge)
                    }, Ke);

                function Ke(t) {
                    "string" == typeof t ? this._fromString(t) : this._fromComponents(t), this._validate()
                }

                var Qe = (Ze.prototype.addScopeListener = function (t) {
                    this._scopeListeners.push(t)
                }, Ze.prototype.addEventProcessor = function (t) {
                    return this._eventProcessors.push(t), this
                }, Ze.prototype._notifyScopeListeners = function () {
                    var t = this;
                    this._notifyingListeners || (this._notifyingListeners = !0, setTimeout((function () {
                        t._scopeListeners.forEach((function (e) {
                            e(t)
                        })), t._notifyingListeners = !1
                    })))
                }, Ze.prototype._notifyEventProcessors = function (t, e, n, r) {
                    var o = this;
                    return void 0 === r && (r = 0), new Le((function (i, a) {
                        var s = t[r];
                        if (null === e || "function" != typeof s) i(e); else {
                            var u = s(c({}, e), n);
                            Qt(u) ? u.then((function (e) {
                                return o._notifyEventProcessors(t, e, n, r + 1).then(i)
                            })).then(null, a) : o._notifyEventProcessors(t, u, n, r + 1).then(i).then(null, a)
                        }
                    }))
                }, Ze.prototype.setUser = function (t) {
                    return this._user = Re(t), this._notifyScopeListeners(), this
                }, Ze.prototype.setTags = function (t) {
                    return this._tags = c({}, this._tags, Re(t)), this._notifyScopeListeners(), this
                }, Ze.prototype.setTag = function (t, e) {
                    var n;
                    return this._tags = c({}, this._tags, ((n = {})[t] = Re(e), n)), this._notifyScopeListeners(), this
                }, Ze.prototype.setExtras = function (t) {
                    return this._extra = c({}, this._extra, Re(t)), this._notifyScopeListeners(), this
                }, Ze.prototype.setExtra = function (t, e) {
                    var n;
                    return this._extra = c({}, this._extra, ((n = {})[t] = Re(e), n)), this._notifyScopeListeners(), this
                }, Ze.prototype.setFingerprint = function (t) {
                    return this._fingerprint = Re(t), this._notifyScopeListeners(), this
                }, Ze.prototype.setLevel = function (t) {
                    return this._level = Re(t), this._notifyScopeListeners(), this
                }, Ze.prototype.setTransaction = function (t) {
                    return this._transaction = t, this._notifyScopeListeners(), this
                }, Ze.prototype.setContext = function (t, e) {
                    return this._context[t] = e ? Re(e) : void 0, this._notifyScopeListeners(), this
                }, Ze.prototype.setSpan = function (t) {
                    return this._span = t, this._notifyScopeListeners(), this
                }, Ze.prototype.getSpan = function () {
                    return this._span
                }, Ze.clone = function (t) {
                    var e = new Ze;
                    return t && (e._breadcrumbs = p(t._breadcrumbs), e._tags = c({}, t._tags), e._extra = c({}, t._extra), e._context = c({}, t._context), e._user = t._user, e._level = t._level, e._span = t._span, e._transaction = t._transaction, e._fingerprint = t._fingerprint, e._eventProcessors = p(t._eventProcessors)), e
                }, Ze.prototype.clear = function () {
                    return this._breadcrumbs = [], this._tags = {}, this._extra = {}, this._user = {}, this._context = {}, this._level = void 0, this._transaction = void 0, this._fingerprint = void 0, this._span = void 0, this._notifyScopeListeners(), this
                }, Ze.prototype.addBreadcrumb = function (t, e) {
                    var n = pe(), r = c({timestamp: n}, t);
                    return this._breadcrumbs = void 0 !== e && 0 <= e ? p(this._breadcrumbs, [Re(r)]).slice(-e) : p(this._breadcrumbs, [Re(r)]), this._notifyScopeListeners(), this
                }, Ze.prototype.clearBreadcrumbs = function () {
                    return this._breadcrumbs = [], this._notifyScopeListeners(), this
                }, Ze.prototype._applyFingerprint = function (t) {
                    t.fingerprint = t.fingerprint ? Array.isArray(t.fingerprint) ? t.fingerprint : [t.fingerprint] : [], this._fingerprint && (t.fingerprint = t.fingerprint.concat(this._fingerprint)), t.fingerprint && !t.fingerprint.length && delete t.fingerprint
                }, Ze.prototype.applyToEvent = function (t, e) {
                    return this._extra && Object.keys(this._extra).length && (t.extra = c({}, this._extra, t.extra)), this._tags && Object.keys(this._tags).length && (t.tags = c({}, this._tags, t.tags)), this._user && Object.keys(this._user).length && (t.user = c({}, this._user, t.user)), this._context && Object.keys(this._context).length && (t.contexts = c({}, this._context, t.contexts)), this._level && (t.level = this._level), this._transaction && (t.transaction = this._transaction), this._span && (t.contexts = t.contexts || {}, t.contexts.trace = this._span.getTraceContext()), this._applyFingerprint(t), t.breadcrumbs = p(t.breadcrumbs || [], this._breadcrumbs), t.breadcrumbs = 0 < t.breadcrumbs.length ? t.breadcrumbs : void 0, this._notifyEventProcessors(p(tn(), this._eventProcessors), t, e)
                }, Ze);

                function Ze() {
                    this._notifyingListeners = !1, this._scopeListeners = [], this._eventProcessors = [], this._breadcrumbs = [], this._user = {}, this._tags = {}, this._extra = {}, this._context = {}
                }

                function tn() {
                    var t = ne();
                    return t.__SENTRY__ = t.__SENTRY__ || {}, t.__SENTRY__.globalEventProcessors = t.__SENTRY__.globalEventProcessors || [], t.__SENTRY__.globalEventProcessors
                }

                function en(t) {
                    tn().push(t)
                }

                var nn = (rn.prototype._invokeClient = function (t) {
                    for (var e, n = [], r = 1; r < arguments.length; r++) n[r - 1] = arguments[r];
                    var o = this.getStackTop();
                    o && o.client && o.client[t] && (e = o.client)[t].apply(e, p(n, [o.scope]))
                }, rn.prototype.isOlderThan = function (t) {
                    return this._version < t
                }, rn.prototype.bindClient = function (t) {
                    this.getStackTop().client = t
                }, rn.prototype.pushScope = function () {
                    var t = this.getStack(), e = 0 < t.length ? t[t.length - 1].scope : void 0, n = Qe.clone(e);
                    return this.getStack().push({client: this.getClient(), scope: n}), n
                }, rn.prototype.popScope = function () {
                    return void 0 !== this.getStack().pop()
                }, rn.prototype.withScope = function (t) {
                    var e = this.pushScope();
                    try {
                        t(e)
                    } finally {
                        this.popScope()
                    }
                }, rn.prototype.getClient = function () {
                    return this.getStackTop().client
                }, rn.prototype.getScope = function () {
                    return this.getStackTop().scope
                }, rn.prototype.getStack = function () {
                    return this._stack
                }, rn.prototype.getStackTop = function () {
                    return this._stack[this._stack.length - 1]
                }, rn.prototype.captureException = function (t, e) {
                    var n = this._lastEventId = re(), r = e;
                    if (!e) {
                        var o = void 0;
                        try {
                            throw new Error("Sentry syntheticException")
                        } catch (t) {
                            o = t
                        }
                        r = {originalException: t, syntheticException: o}
                    }
                    return this._invokeClient("captureException", t, c({}, r, {event_id: n})), n
                }, rn.prototype.captureMessage = function (t, e, n) {
                    var r = this._lastEventId = re(), o = n;
                    if (!n) {
                        var i = void 0;
                        try {
                            throw new Error(t)
                        } catch (t) {
                            i = t
                        }
                        o = {originalException: t, syntheticException: i}
                    }
                    return this._invokeClient("captureMessage", t, e, c({}, o, {event_id: r})), r
                }, rn.prototype.captureEvent = function (t, e) {
                    var n = this._lastEventId = re();
                    return this._invokeClient("captureEvent", t, c({}, e, {event_id: n})), n
                }, rn.prototype.lastEventId = function () {
                    return this._lastEventId
                }, rn.prototype.addBreadcrumb = function (t, e) {
                    var n = this.getStackTop();
                    if (n.scope && n.client) {
                        var r = n.client.getOptions && n.client.getOptions() || {}, o = r.beforeBreadcrumb,
                            i = void 0 === o ? null : o, a = r.maxBreadcrumbs, s = void 0 === a ? 30 : a;
                        if (!(s <= 0)) {
                            var u = pe(), l = c({timestamp: u}, t), p = i ? ae((function () {
                                return i(l, e)
                            })) : l;
                            null !== p && n.scope.addBreadcrumb(p, Math.min(s, 100))
                        }
                    }
                }, rn.prototype.setUser = function (t) {
                    var e = this.getStackTop();
                    e.scope && e.scope.setUser(t)
                }, rn.prototype.setTags = function (t) {
                    var e = this.getStackTop();
                    e.scope && e.scope.setTags(t)
                }, rn.prototype.setExtras = function (t) {
                    var e = this.getStackTop();
                    e.scope && e.scope.setExtras(t)
                }, rn.prototype.setTag = function (t, e) {
                    var n = this.getStackTop();
                    n.scope && n.scope.setTag(t, e)
                }, rn.prototype.setExtra = function (t, e) {
                    var n = this.getStackTop();
                    n.scope && n.scope.setExtra(t, e)
                }, rn.prototype.setContext = function (t, e) {
                    var n = this.getStackTop();
                    n.scope && n.scope.setContext(t, e)
                }, rn.prototype.configureScope = function (t) {
                    var e = this.getStackTop();
                    e.scope && e.client && t(e.scope)
                }, rn.prototype.run = function (t) {
                    var e = an(this);
                    try {
                        t(this)
                    } finally {
                        an(e)
                    }
                }, rn.prototype.getIntegration = function (t) {
                    var e = this.getClient();
                    if (!e) return null;
                    try {
                        return e.getIntegration(t)
                    } catch (e) {
                        return we.warn("Cannot retrieve integration " + t.id + " from the current Hub"), null
                    }
                }, rn.prototype.startSpan = function (t, e) {
                    return void 0 === e && (e = !1), this._callExtensionMethod("startSpan", t, e)
                }, rn.prototype.traceHeaders = function () {
                    return this._callExtensionMethod("traceHeaders")
                }, rn.prototype._callExtensionMethod = function (t) {
                    for (var e = [], n = 1; n < arguments.length; n++) e[n - 1] = arguments[n];
                    var r = on().__SENTRY__;
                    if (r && r.extensions && "function" == typeof r.extensions[t]) return r.extensions[t].apply(this, e);
                    we.warn("Extension method " + t + " couldn't be found, doing nothing.")
                }, rn);

                function rn(t, e, n) {
                    void 0 === e && (e = new Qe), void 0 === n && (n = 3), this._version = n, this._stack = [], this._stack.push({
                        client: t,
                        scope: e
                    })
                }

                function on() {
                    var t = ne();
                    return t.__SENTRY__ = t.__SENTRY__ || {extensions: {}, hub: void 0}, t
                }

                function an(t) {
                    var e = on(), n = un(e);
                    return ln(e, t), n
                }

                function sn() {
                    var t = on();
                    return cn(t) && !un(t).isOlderThan(3) || ln(t, new nn), te() ? function (t) {
                        try {
                            var e = function (t, e) {
                                return t.require("domain")
                            }(r).active;
                            if (!e) return un(t);
                            if (!cn(e) || un(e).isOlderThan(3)) {
                                var n = un(t).getStackTop();
                                ln(e, new nn(n.client, Qe.clone(n.scope)))
                            }
                            return un(e)
                        } catch (e) {
                            return un(t)
                        }
                    }(t) : un(t)
                }

                function cn(t) {
                    return !!(t && t.__SENTRY__ && t.__SENTRY__.hub)
                }

                function un(t) {
                    return t && t.__SENTRY__ && t.__SENTRY__.hub || (t.__SENTRY__ = t.__SENTRY__ || {}, t.__SENTRY__.hub = new nn), t.__SENTRY__.hub
                }

                function ln(t, e) {
                    return !!t && (t.__SENTRY__ = t.__SENTRY__ || {}, t.__SENTRY__.hub = e, !0)
                }

                function pn(t) {
                    for (var e = [], n = 1; n < arguments.length; n++) e[n - 1] = arguments[n];
                    var r = sn();
                    if (r && r[t]) return r[t].apply(r, p(e));
                    throw new Error("No hub defined or " + t + " was not found on the hub, please open a bug report.")
                }

                function hn(t) {
                    var e;
                    try {
                        throw new Error("Sentry syntheticException")
                    } catch (t) {
                        e = t
                    }
                    return pn("captureException", t, {originalException: t, syntheticException: e})
                }

                function dn(t, e) {
                    var n;
                    try {
                        throw new Error(t)
                    } catch (t) {
                        n = t
                    }
                    return pn("captureMessage", t, e, {originalException: t, syntheticException: n})
                }

                function fn(t) {
                    pn("configureScope", t)
                }

                function vn(t) {
                    pn("withScope", t)
                }

                var _n = (mn.prototype.getDsn = function () {
                    return this._dsnObject
                }, mn.prototype.getStoreEndpoint = function () {
                    return "" + this._getBaseUrl() + this.getStoreEndpointPath()
                }, mn.prototype.getStoreEndpointWithUrlEncodedAuth = function () {
                    var t, e = {sentry_key: this._dsnObject.user, sentry_version: "7"};
                    return this.getStoreEndpoint() + "?" + (t = e, Object.keys(t).map((function (e) {
                        return encodeURIComponent(e) + "=" + encodeURIComponent(t[e])
                    })).join("&"))
                }, mn.prototype._getBaseUrl = function () {
                    var t = this._dsnObject, e = t.protocol ? t.protocol + ":" : "", n = t.port ? ":" + t.port : "";
                    return e + "//" + t.host + n
                }, mn.prototype.getStoreEndpointPath = function () {
                    var t = this._dsnObject;
                    return (t.path ? "/" + t.path : "") + "/api/" + t.projectId + "/store/"
                }, mn.prototype.getRequestHeaders = function (t, e) {
                    var n = this._dsnObject, r = ["Sentry sentry_version=7"];
                    return r.push("sentry_timestamp=" + pe()), r.push("sentry_client=" + t + "/" + e), r.push("sentry_key=" + n.user), n.pass && r.push("sentry_secret=" + n.pass), {
                        "Content-Type": "application/json",
                        "X-Sentry-Auth": r.join(", ")
                    }
                }, mn.prototype.getReportDialogEndpoint = function (t) {
                    void 0 === t && (t = {});
                    var e = this._dsnObject,
                        n = this._getBaseUrl() + (e.path ? "/" + e.path : "") + "/api/embed/error-page/", r = [];
                    for (var o in r.push("dsn=" + e.toString()), t) if ("user" === o) {
                        if (!t.user) continue;
                        t.user.name && r.push("name=" + encodeURIComponent(t.user.name)), t.user.email && r.push("email=" + encodeURIComponent(t.user.email))
                    } else r.push(encodeURIComponent(o) + "=" + encodeURIComponent(t[o]));
                    return r.length ? n + "?" + r.join("&") : n
                }, mn);

                function mn(t) {
                    this.dsn = t, this._dsnObject = new $e(t)
                }

                var gn = [], yn = (bn.prototype.captureException = function (t, e, n) {
                    var r = this, o = e && e.event_id;
                    return this._processing = !0, this._getBackend().eventFromException(t, e).then((function (t) {
                        return r._processEvent(t, e, n)
                    })).then((function (t) {
                        o = t && t.event_id, r._processing = !1
                    })).then(null, (function (t) {
                        we.error(t), r._processing = !1
                    })), o
                }, bn.prototype.captureMessage = function (t, e, n, r) {
                    var o = this, i = n && n.event_id;
                    return this._processing = !0, (Jt(t) ? this._getBackend().eventFromMessage("" + t, e, n) : this._getBackend().eventFromException(t, n)).then((function (t) {
                        return o._processEvent(t, n, r)
                    })).then((function (t) {
                        i = t && t.event_id, o._processing = !1
                    })).then(null, (function (t) {
                        we.error(t), o._processing = !1
                    })), i
                }, bn.prototype.captureEvent = function (t, e, n) {
                    var r = this, o = e && e.event_id;
                    return this._processing = !0, this._processEvent(t, e, n).then((function (t) {
                        o = t && t.event_id, r._processing = !1
                    })).then(null, (function (t) {
                        we.error(t), r._processing = !1
                    })), o
                }, bn.prototype.getDsn = function () {
                    return this._dsn
                }, bn.prototype.getOptions = function () {
                    return this._options
                }, bn.prototype.flush = function (t) {
                    var e = this;
                    return this._isClientProcessing(t).then((function (n) {
                        return clearInterval(n.interval), e._getBackend().getTransport().close(t).then((function (t) {
                            return n.ready && t
                        }))
                    }))
                }, bn.prototype.close = function (t) {
                    var e = this;
                    return this.flush(t).then((function (t) {
                        return e.getOptions().enabled = !1, t
                    }))
                }, bn.prototype.getIntegrations = function () {
                    return this._integrations || {}
                }, bn.prototype.getIntegration = function (t) {
                    try {
                        return this._integrations[t.id] || null
                    } catch (e) {
                        return we.warn("Cannot retrieve integration " + t.id + " from the current Client"), null
                    }
                }, bn.prototype._isClientProcessing = function (t) {
                    var e = this;
                    return new Le((function (n) {
                        var r = 0, o = 0;
                        clearInterval(o), o = setInterval((function () {
                            e._processing ? (r += 1, t && t <= r && n({interval: o, ready: !1})) : n({
                                interval: o,
                                ready: !0
                            })
                        }), 1)
                    }))
                }, bn.prototype._getBackend = function () {
                    return this._backend
                }, bn.prototype._isEnabled = function () {
                    return !1 !== this.getOptions().enabled && void 0 !== this._dsn
                }, bn.prototype._prepareEvent = function (t, e, n) {
                    var r = this.getOptions(), o = r.environment, i = r.release, a = r.dist, s = r.maxValueLength,
                        u = void 0 === s ? 250 : s, l = c({}, t);
                    void 0 === l.environment && void 0 !== o && (l.environment = o), void 0 === l.release && void 0 !== i && (l.release = i), void 0 === l.dist && void 0 !== a && (l.dist = a), l.message && (l.message = xe(l.message, u));
                    var p = l.exception && l.exception.values && l.exception.values[0];
                    p && p.value && (p.value = xe(p.value, u));
                    var h = l.request;
                    h && h.url && (h.url = xe(h.url, u)), void 0 === l.event_id && (l.event_id = re()), this._addIntegrations(l.sdk);
                    var d = Le.resolve(l);
                    return e && (d = e.applyToEvent(l, n)), d
                }, bn.prototype._addIntegrations = function (t) {
                    var e = Object.keys(this._integrations);
                    t && 0 < e.length && (t.integrations = e)
                }, bn.prototype._processEvent = function (t, e, n) {
                    var r = this, o = this.getOptions(), i = o.beforeSend, a = o.sampleRate;
                    return this._isEnabled() ? "number" == typeof a && Math.random() > a ? Le.reject("This event has been sampled, will not send event.") : new Le((function (o, a) {
                        r._prepareEvent(t, n, e).then((function (t) {
                            if (null !== t) {
                                var n = t;
                                try {
                                    if (e && e.data && !0 === e.data.__sentry__ || !i) return r._getBackend().sendEvent(n), void o(n);
                                    var s = i(t, e);
                                    if (void 0 === s) we.error("`beforeSend` method has to return `null` or a valid event."); else if (Qt(s)) r._handleAsyncBeforeSend(s, o, a); else {
                                        if (null === (n = s)) return we.log("`beforeSend` returned `null`, will not send event."), void o(null);
                                        r._getBackend().sendEvent(n), o(n)
                                    }
                                } catch (t) {
                                    r.captureException(t, {
                                        data: {__sentry__: !0},
                                        originalException: t
                                    }), a("`beforeSend` threw an error, will not send event.")
                                }
                            } else a("An event processor returned null, will not send event.")
                        })).then(null, (function () {
                            a("`beforeSend` threw an error, will not send event.")
                        }))
                    })) : Le.reject("SDK not enabled, will not send event.")
                }, bn.prototype._handleAsyncBeforeSend = function (t, e, n) {
                    var r = this;
                    t.then((function (t) {
                        null !== t ? (r._getBackend().sendEvent(t), e(t)) : n("`beforeSend` returned `null`, will not send event.")
                    })).then(null, (function (t) {
                        n("beforeSend rejected with " + t)
                    }))
                }, bn);

                function bn(t, e) {
                    this._integrations = {}, this._processing = !1, this._backend = new t(e), (this._options = e).dsn && (this._dsn = new $e(e.dsn)), this._isEnabled() && (this._integrations = function (t) {
                        var e = {};
                        return function (t) {
                            var e = t.defaultIntegrations && p(t.defaultIntegrations) || [], n = t.integrations, r = [];
                            if (Array.isArray(n)) {
                                var o = n.map((function (t) {
                                    return t.name
                                })), i = [];
                                e.forEach((function (t) {
                                    -1 === o.indexOf(t.name) && -1 === i.indexOf(t.name) && (r.push(t), i.push(t.name))
                                })), n.forEach((function (t) {
                                    -1 === i.indexOf(t.name) && (r.push(t), i.push(t.name))
                                }))
                            } else r = "function" == typeof n ? (r = n(e), Array.isArray(r) ? r : [r]) : p(e);
                            var a = r.map((function (t) {
                                return t.name
                            }));
                            return -1 !== a.indexOf("Debug") && r.push.apply(r, p(r.splice(a.indexOf("Debug"), 1))), r
                        }(t).forEach((function (t) {
                            var n;
                            e[t.name] = t, n = t, -1 === gn.indexOf(n.name) && (n.setupOnce(en, sn), gn.push(n.name), we.log("Integration installed: " + n.name))
                        })), e
                    }(this._options))
                }

                var wn = (En.prototype.sendEvent = function (t) {
                    return Le.resolve({
                        reason: "NoopTransport: Event has been skipped because no Dsn is configured.",
                        status: Pt.Skipped
                    })
                }, En.prototype.close = function (t) {
                    return Le.resolve(!0)
                }, En);

                function En() {
                }

                var Sn, xn = (kn.prototype._setupTransport = function () {
                    return new wn
                }, kn.prototype.eventFromException = function (t, e) {
                    throw new qt("Backend has to implement `eventFromException` method")
                }, kn.prototype.eventFromMessage = function (t, e, n) {
                    throw new qt("Backend has to implement `eventFromMessage` method")
                }, kn.prototype.sendEvent = function (t) {
                    this._transport.sendEvent(t).then(null, (function (t) {
                        we.error("Error while sending event: " + t)
                    }))
                }, kn.prototype.getTransport = function () {
                    return this._transport
                }, kn);

                function kn(t) {
                    this._options = t, this._options.dsn || we.warn("No DSN provided, backend will not do anything."), this._transport = this._setupTransport()
                }

                var Tn = (On.prototype.setupOnce = function () {
                    Sn = Function.prototype.toString, Function.prototype.toString = function () {
                        for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
                        var n = this.__sentry_original__ || this;
                        return Sn.apply(n, t)
                    }
                }, On.id = "FunctionToString", On);

                function On() {
                    this.name = On.id
                }

                var jn = [/^Script error\.?$/, /^Javascript error: Script error\.? on line 0$/],
                    Cn = (Rn.prototype.setupOnce = function () {
                        en((function (t) {
                            var e = sn();
                            if (!e) return t;
                            var n = e.getIntegration(Rn);
                            if (n) {
                                var r = e.getClient(), o = r ? r.getOptions() : {}, i = n._mergeOptions(o);
                                if (n._shouldDropEvent(t, i)) return null
                            }
                            return t
                        }))
                    }, Rn.prototype._shouldDropEvent = function (t, e) {
                        return this._isSentryError(t, e) ? (we.warn("Event dropped due to being internal Sentry Error.\nEvent: " + ie(t)), !0) : this._isIgnoredError(t, e) ? (we.warn("Event dropped due to being matched by `ignoreErrors` option.\nEvent: " + ie(t)), !0) : this._isBlacklistedUrl(t, e) ? (we.warn("Event dropped due to being matched by `blacklistUrls` option.\nEvent: " + ie(t) + ".\nUrl: " + this._getEventFilterUrl(t)), !0) : !this._isWhitelistedUrl(t, e) && (we.warn("Event dropped due to not being matched by `whitelistUrls` option.\nEvent: " + ie(t) + ".\nUrl: " + this._getEventFilterUrl(t)), !0)
                    }, Rn.prototype._isSentryError = function (t, e) {
                        if (void 0 === e && (e = {}), !e.ignoreInternal) return !1;
                        try {
                            return t && t.exception && t.exception.values && t.exception.values[0] && "SentryError" === t.exception.values[0].type || !1
                        } catch (t) {
                            return !1
                        }
                    }, Rn.prototype._isIgnoredError = function (t, e) {
                        return void 0 === e && (e = {}), !(!e.ignoreErrors || !e.ignoreErrors.length) && this._getPossibleEventMessages(t).some((function (t) {
                            return e.ignoreErrors.some((function (e) {
                                return Te(t, e)
                            }))
                        }))
                    }, Rn.prototype._isBlacklistedUrl = function (t, e) {
                        if (void 0 === e && (e = {}), !e.blacklistUrls || !e.blacklistUrls.length) return !1;
                        var n = this._getEventFilterUrl(t);
                        return !!n && e.blacklistUrls.some((function (t) {
                            return Te(n, t)
                        }))
                    }, Rn.prototype._isWhitelistedUrl = function (t, e) {
                        if (void 0 === e && (e = {}), !e.whitelistUrls || !e.whitelistUrls.length) return !0;
                        var n = this._getEventFilterUrl(t);
                        return !n || e.whitelistUrls.some((function (t) {
                            return Te(n, t)
                        }))
                    }, Rn.prototype._mergeOptions = function (t) {
                        return void 0 === t && (t = {}), {
                            blacklistUrls: p(this._options.blacklistUrls || [], t.blacklistUrls || []),
                            ignoreErrors: p(this._options.ignoreErrors || [], t.ignoreErrors || [], jn),
                            ignoreInternal: void 0 === this._options.ignoreInternal || this._options.ignoreInternal,
                            whitelistUrls: p(this._options.whitelistUrls || [], t.whitelistUrls || [])
                        }
                    }, Rn.prototype._getPossibleEventMessages = function (t) {
                        if (t.message) return [t.message];
                        if (t.exception) try {
                            var e = t.exception.values && t.exception.values[0] || {}, n = e.type, r = e.value,
                                o = void 0 === r ? "" : r;
                            return ["" + o, (void 0 === n ? "" : n) + ": " + o]
                        } catch (e) {
                            return we.error("Cannot extract message for event " + ie(t)), []
                        }
                        return []
                    }, Rn.prototype._getEventFilterUrl = function (t) {
                        try {
                            if (t.stacktrace) {
                                var e = t.stacktrace.frames;
                                return e && e[e.length - 1].filename || null
                            }
                            if (t.exception) {
                                var n = t.exception.values && t.exception.values[0].stacktrace && t.exception.values[0].stacktrace.frames;
                                return n && n[n.length - 1].filename || null
                            }
                            return null
                        } catch (e) {
                            return we.error("Cannot extract url for event " + ie(t)), null
                        }
                    }, Rn.id = "InboundFilters", Rn);

                function Rn(t) {
                    void 0 === t && (t = {}), this._options = t, this.name = Rn.id
                }

                var Ln = Object.freeze({__proto__: null, FunctionToString: Tn, InboundFilters: Cn}),
                    Pn = /^\s*at (?:(.*?) ?\()?((?:file|https?|blob|chrome-extension|native|eval|webpack|<anonymous>|[-a-z]+:|\/).*?)(?::(\d+))?(?::(\d+))?\)?\s*$/i,
                    Mn = /^\s*(.*?)(?:\((.*?)\))?(?:^|@)?((?:file|https?|blob|chrome|webpack|resource|moz-extension).*?:\/.*?|\[native code\]|[^@]*(?:bundle|\d+\.js))(?::(\d+))?(?::(\d+))?\s*$/i,
                    Dn = /^\s*at (?:((?:\[object object\])?.+) )?\(?((?:file|ms-appx|https?|webpack|blob):.*?):(\d+)(?::(\d+))?\)?\s*$/i,
                    In = /(\S+) line (\d+)(?: > eval line \d+)* > eval/i, Nn = /\((\S*)(?::(\d+))(?::(\d+))\)/;

                function An(t) {
                    var e = null, n = t && t.framesToPop;
                    try {
                        if (e = function (t) {
                            if (!t || !t.stacktrace) return null;
                            for (var e, n = / line (\d+).*script (?:in )?(\S+)(?:: in function (\S+))?$/i, r = / line (\d+), column (\d+)\s*(?:in (?:<anonymous function: ([^>]+)>|([^\)]+))\((.*)\))? in (.*):\s*$/i, o = t.stacktrace.split("\n"), i = [], a = 0; a < o.length; a += 2) {
                                var s = null;
                                (e = n.exec(o[a])) ? s = {
                                    url: e[2],
                                    func: e[3],
                                    args: [],
                                    line: +e[1],
                                    column: null
                                } : (e = r.exec(o[a])) && (s = {
                                    url: e[6],
                                    func: e[3] || e[4],
                                    args: e[5] ? e[5].split(",") : [],
                                    line: +e[1],
                                    column: +e[2]
                                }), s && (!s.func && s.line && (s.func = "?"), i.push(s))
                            }
                            return i.length ? {message: Hn(t), name: t.name, stack: i} : null
                        }(t)) return Un(e, n)
                    } catch (t) {
                    }
                    try {
                        if (e = function (t) {
                            if (!t || !t.stack) return null;
                            for (var e, n, r, o = [], i = t.stack.split("\n"), a = 0; a < i.length; ++a) {
                                if (n = Pn.exec(i[a])) {
                                    var s = n[2] && 0 === n[2].indexOf("native");
                                    n[2] && 0 === n[2].indexOf("eval") && (e = Nn.exec(n[2])) && (n[2] = e[1], n[3] = e[2], n[4] = e[3]), r = {
                                        url: n[2],
                                        func: n[1] || "?",
                                        args: s ? [n[2]] : [],
                                        line: n[3] ? +n[3] : null,
                                        column: n[4] ? +n[4] : null
                                    }
                                } else if (n = Dn.exec(i[a])) r = {
                                    url: n[2],
                                    func: n[1] || "?",
                                    args: [],
                                    line: +n[3],
                                    column: n[4] ? +n[4] : null
                                }; else {
                                    if (!(n = Mn.exec(i[a]))) continue;
                                    n[3] && -1 < n[3].indexOf(" > eval") && (e = In.exec(n[3])) ? (n[1] = n[1] || "eval", n[3] = e[1], n[4] = e[2], n[5] = "") : 0 !== a || n[5] || void 0 === t.columnNumber || (o[0].column = t.columnNumber + 1), r = {
                                        url: n[3],
                                        func: n[1] || "?",
                                        args: n[2] ? n[2].split(",") : [],
                                        line: n[4] ? +n[4] : null,
                                        column: n[5] ? +n[5] : null
                                    }
                                }
                                !r.func && r.line && (r.func = "?"), o.push(r)
                            }
                            return o.length ? {message: Hn(t), name: t.name, stack: o} : null
                        }(t)) return Un(e, n)
                    } catch (t) {
                    }
                    return {message: Hn(t), name: t && t.name, stack: [], failed: !0}
                }

                function Un(t, e) {
                    try {
                        return c({}, t, {stack: t.stack.slice(e)})
                    } catch (e) {
                        return t
                    }
                }

                function Hn(t) {
                    var e = t && t.message;
                    return e ? e.error && "string" == typeof e.error.message ? e.error.message : e : "No error message"
                }

                function Fn(t) {
                    var e = Wn(t.stack), n = {type: t.name, value: t.message};
                    return e && e.length && (n.stacktrace = {frames: e}), void 0 === n.type && "" === n.value && (n.value = "Unrecoverable error caught"), n
                }

                function Bn(t, e, n) {
                    var r = {
                        exception: {
                            values: [{
                                type: $t(t) ? t.constructor.name : n ? "UnhandledRejection" : "Error",
                                value: "Non-Error " + (n ? "promise rejection" : "exception") + " captured with keys: " + function (t, e) {
                                    void 0 === e && (e = 40);
                                    var n = Object.keys(je(t));
                                    if (n.sort(), !n.length) return "[object has no keys]";
                                    if (n[0].length >= e) return xe(n[0], e);
                                    for (var r = n.length; 0 < r; r--) {
                                        var o = n.slice(0, r).join(", ");
                                        if (!(o.length > e)) return r === n.length ? o : xe(o, e)
                                    }
                                    return ""
                                }(t)
                            }]
                        }, extra: {
                            __serialized__: function t(e, n, r) {
                                void 0 === n && (n = 3), void 0 === r && (r = 102400);
                                var o = Re(e, n);
                                return function (t) {
                                    return e = JSON.stringify(t), ~-encodeURI(e).split(/%..|./).length;
                                    var e
                                }(o) > r ? t(e, n - 1, r) : o
                            }(t)
                        }
                    };
                    if (e) {
                        var o = Wn(An(e).stack);
                        r.stacktrace = {frames: o}
                    }
                    return r
                }

                function qn(t) {
                    return {exception: {values: [Fn(t)]}}
                }

                function Wn(t) {
                    if (!t || !t.length) return [];
                    var e = t, n = e[0].func || "", r = e[e.length - 1].func || "";
                    return -1 === n.indexOf("captureMessage") && -1 === n.indexOf("captureException") || (e = e.slice(1)), -1 !== r.indexOf("sentryWrapped") && (e = e.slice(0, -1)), e.map((function (t) {
                        return {
                            colno: null === t.column ? void 0 : t.column,
                            filename: t.url || e[0].url,
                            function: t.func || "?",
                            in_app: !0,
                            lineno: null === t.line ? void 0 : t.line
                        }
                    })).slice(0, 50).reverse()
                }

                function Xn(t, e, n) {
                    var r, o;
                    if (void 0 === n && (n = {}), Yt(t) && t.error) return qn(An(t = t.error));
                    if (zt(t) || (o = t, "[object DOMException]" === Object.prototype.toString.call(o))) {
                        var i = t, a = i.name || (zt(i) ? "DOMError" : "DOMException"),
                            s = i.message ? a + ": " + i.message : a;
                        return se(r = Yn(s, e, n), s), r
                    }
                    return Xt(t) ? r = qn(An(t)) : (Gt(t) || $t(t) ? ce(r = Bn(t, e, n.rejection), {synthetic: !0}) : (se(r = Yn(t, e, n), "" + t, void 0), ce(r, {synthetic: !0})), r)
                }

                function Yn(t, e, n) {
                    void 0 === n && (n = {});
                    var r = {message: t};
                    if (n.attachStacktrace && e) {
                        var o = Wn(An(e).stack);
                        r.stacktrace = {frames: o}
                    }
                    return r
                }

                var zn = (Vn.prototype.sendEvent = function (t) {
                    throw new qt("Transport Class has to implement `sendEvent` method")
                }, Vn.prototype.close = function (t) {
                    return this._buffer.drain(t)
                }, Vn);

                function Vn(t) {
                    this.options = t, this._buffer = new Me(30), this.url = new _n(this.options.dsn).getStoreEndpointWithUrlEncodedAuth()
                }

                var Jn, Gn = ne(), $n = (s(Kn, Jn = zn), Kn.prototype.sendEvent = function (t) {
                    var e = this;
                    if (new Date(Date.now()) < this._disabledUntil) return Promise.reject({
                        event: t,
                        reason: "Transport locked till " + this._disabledUntil + " due to too many requests.",
                        status: 429
                    });
                    var n = {
                        body: JSON.stringify(t), method: "POST", referrerPolicy: function () {
                            if (!Ie()) return 0;
                            try {
                                return new Request("_", {referrerPolicy: "origin"}), 1
                            } catch (t) {
                                return 0
                            }
                        }() ? "origin" : ""
                    };
                    return this._buffer.add(new Le((function (t, r) {
                        Gn.fetch(e.url, n).then((function (n) {
                            var o = Pt.fromHttpCode(n.status);
                            if (o !== Pt.Success) {
                                if (o === Pt.RateLimit) {
                                    var i = Date.now();
                                    e._disabledUntil = new Date(i + he(i, n.headers.get("Retry-After"))), we.warn("Too many requests, backing off till: " + e._disabledUntil)
                                }
                                r(n)
                            } else t({status: o})
                        })).catch(r)
                    })))
                }, Kn);

                function Kn() {
                    var t = null !== Jn && Jn.apply(this, arguments) || this;
                    return t._disabledUntil = new Date(Date.now()), t
                }

                var Qn, Zn = (s(tr, Qn = zn), tr.prototype.sendEvent = function (t) {
                    var e = this;
                    return new Date(Date.now()) < this._disabledUntil ? Promise.reject({
                        event: t,
                        reason: "Transport locked till " + this._disabledUntil + " due to too many requests.",
                        status: 429
                    }) : this._buffer.add(new Le((function (n, r) {
                        var o = new XMLHttpRequest;
                        o.onreadystatechange = function () {
                            if (4 === o.readyState) {
                                var t = Pt.fromHttpCode(o.status);
                                if (t !== Pt.Success) {
                                    if (t === Pt.RateLimit) {
                                        var i = Date.now();
                                        e._disabledUntil = new Date(i + he(i, o.getResponseHeader("Retry-After"))), we.warn("Too many requests, backing off till: " + e._disabledUntil)
                                    }
                                    r(o)
                                } else n({status: t})
                            }
                        }, o.open("POST", e.url), o.send(JSON.stringify(t))
                    })))
                }, tr);

                function tr() {
                    var t = null !== Qn && Qn.apply(this, arguments) || this;
                    return t._disabledUntil = new Date(Date.now()), t
                }

                var er, nr = Object.freeze({__proto__: null, BaseTransport: zn, FetchTransport: $n, XHRTransport: Zn}),
                    rr = (s(or, er = xn), or.prototype._setupTransport = function () {
                        if (!this._options.dsn) return er.prototype._setupTransport.call(this);
                        var t = c({}, this._options.transportOptions, {dsn: this._options.dsn});
                        return this._options.transport ? new this._options.transport(t) : Ie() ? new $n(t) : new Zn(t)
                    }, or.prototype.eventFromException = function (t, e) {
                        var n = Xn(t, e && e.syntheticException || void 0, {attachStacktrace: this._options.attachStacktrace});
                        return ce(n, {
                            handled: !0,
                            type: "generic"
                        }), n.level = Tt.Error, e && e.event_id && (n.event_id = e.event_id), Le.resolve(n)
                    }, or.prototype.eventFromMessage = function (t, e, n) {
                        void 0 === e && (e = Tt.Info);
                        var r = Yn(t, n && n.syntheticException || void 0, {attachStacktrace: this._options.attachStacktrace});
                        return r.level = e, n && n.event_id && (r.event_id = n.event_id), Le.resolve(r)
                    }, or);

                function or() {
                    return null !== er && er.apply(this, arguments) || this
                }

                var ir, ar = "sentry.javascript.browser", sr = "5.10.2",
                    cr = (s(ur, ir = yn), ur.prototype._prepareEvent = function (t, e, n) {
                        return t.platform = t.platform || "javascript", t.sdk = c({}, t.sdk, {
                            name: ar,
                            packages: p(t.sdk && t.sdk.packages || [], [{name: "npm:@sentry/browser", version: sr}]),
                            version: sr
                        }), ir.prototype._prepareEvent.call(this, t, e, n)
                    }, ur.prototype.showReportDialog = function (t) {
                        void 0 === t && (t = {});
                        var e = ne().document;
                        if (e) if (this._isEnabled()) {
                            var n = t.dsn || this.getDsn();
                            if (t.eventId) if (n) {
                                var r = e.createElement("script");
                                r.async = !0, r.src = new _n(n).getReportDialogEndpoint(t), t.onLoad && (r.onload = t.onLoad), (e.head || e.body).appendChild(r)
                            } else we.error("Missing `Dsn` option in showReportDialog call"); else we.error("Missing `eventId` option in showReportDialog call")
                        } else we.error("Trying to call showReportDialog with Sentry Client is disabled")
                    }, ur);

                function ur(t) {
                    return void 0 === t && (t = {}), ir.call(this, rr, t) || this
                }

                var lr = 0;

                function pr() {
                    return 0 < lr
                }

                function hr(t, e, n) {
                    if (void 0 === e && (e = {}), "function" != typeof t) return t;
                    try {
                        if (t.__sentry__) return t;
                        if (t.__sentry_wrapped__) return t.__sentry_wrapped__
                    } catch (r) {
                        return t
                    }

                    function r() {
                        var r = Array.prototype.slice.call(arguments);
                        try {
                            n && "function" == typeof n && n.apply(this, arguments);
                            var o = r.map((function (t) {
                                return hr(t, e)
                            }));
                            return t.handleEvent ? t.handleEvent.apply(this, o) : t.apply(this, o)
                        } catch (t) {
                            throw lr += 1, setTimeout((function () {
                                --lr
                            })), vn((function (n) {
                                n.addEventProcessor((function (t) {
                                    var n = c({}, t);
                                    return e.mechanism && (se(n, void 0, void 0), ce(n, e.mechanism)), n.extra = c({}, n.extra, {arguments: Re(r, 3)}), n
                                })), hn(t)
                            })), t
                        }
                    }

                    try {
                        for (var o in t) Object.prototype.hasOwnProperty.call(t, o) && (r[o] = t[o])
                    } catch (r) {
                    }
                    t.prototype = t.prototype || {}, r.prototype = t.prototype, Object.defineProperty(t, "__sentry_wrapped__", {
                        enumerable: !1,
                        value: r
                    }), Object.defineProperties(r, {
                        __sentry__: {enumerable: !1, value: !0},
                        __sentry_original__: {enumerable: !1, value: t}
                    });
                    try {
                        Object.getOwnPropertyDescriptor(r, "name").configurable && Object.defineProperty(r, "name", {
                            get: function () {
                                return t.name
                            }
                        })
                    } catch (r) {
                    }
                    return r
                }

                var dr = (fr.prototype.setupOnce = function () {
                    Error.stackTraceLimit = 50, this._options.onerror && (we.log("Global Handler attached: onerror"), this._installGlobalOnErrorHandler()), this._options.onunhandledrejection && (we.log("Global Handler attached: onunhandledrejection"), this._installGlobalOnUnhandledRejectionHandler())
                }, fr.prototype._installGlobalOnErrorHandler = function () {
                    if (!this._onErrorHandlerInstalled) {
                        var t = this;
                        this._oldOnErrorHandler = this._global.onerror, this._global.onerror = function (e, n, r, o, i) {
                            var a = sn(), s = a.getIntegration(fr), c = i && !0 === i.__sentry_own_request__;
                            if (!s || pr() || c) return !!t._oldOnErrorHandler && t._oldOnErrorHandler.apply(this, arguments);
                            var u = a.getClient(),
                                l = Jt(i) ? t._eventFromIncompleteOnError(e, n, r, o) : t._enhanceEventWithInitialFrame(Xn(i, void 0, {
                                    attachStacktrace: u && u.getOptions().attachStacktrace,
                                    rejection: !1
                                }), n, r, o);
                            return ce(l, {
                                handled: !1,
                                type: "onerror"
                            }), a.captureEvent(l, {originalException: i}), !!t._oldOnErrorHandler && t._oldOnErrorHandler.apply(this, arguments)
                        }, this._onErrorHandlerInstalled = !0
                    }
                }, fr.prototype._installGlobalOnUnhandledRejectionHandler = function () {
                    if (!this._onUnhandledRejectionHandlerInstalled) {
                        var t = this;
                        this._oldOnUnhandledRejectionHandler = this._global.onunhandledrejection, this._global.onunhandledrejection = function (e) {
                            var n = e;
                            try {
                                n = e && "reason" in e ? e.reason : e
                            } catch (e) {
                            }
                            var r = sn(), o = r.getIntegration(fr), i = n && !0 === n.__sentry_own_request__;
                            if (!o || pr() || i) return !t._oldOnUnhandledRejectionHandler || t._oldOnUnhandledRejectionHandler.apply(this, arguments);
                            var a = r.getClient(), s = Jt(n) ? t._eventFromIncompleteRejection(n) : Xn(n, void 0, {
                                attachStacktrace: a && a.getOptions().attachStacktrace,
                                rejection: !0
                            });
                            return s.level = Tt.Error, ce(s, {
                                handled: !1,
                                type: "onunhandledrejection"
                            }), r.captureEvent(s, {originalException: n}), !t._oldOnUnhandledRejectionHandler || t._oldOnUnhandledRejectionHandler.apply(this, arguments)
                        }, this._onUnhandledRejectionHandlerInstalled = !0
                    }
                }, fr.prototype._eventFromIncompleteOnError = function (t, e, n, r) {
                    var o, i = Yt(t) ? t.message : t;
                    if (Vt(i)) {
                        var a = i.match(/^(?:[Uu]ncaught (?:exception: )?)?(?:((?:Eval|Internal|Range|Reference|Syntax|Type|URI|)Error): )?(.*)$/i);
                        a && (o = a[1], i = a[2])
                    }
                    var s = {exception: {values: [{type: o || "Error", value: i}]}};
                    return this._enhanceEventWithInitialFrame(s, e, n, r)
                }, fr.prototype._eventFromIncompleteRejection = function (t) {
                    return {
                        exception: {
                            values: [{
                                type: "UnhandledRejection",
                                value: "Non-Error promise rejection captured with value: " + t
                            }]
                        }
                    }
                }, fr.prototype._enhanceEventWithInitialFrame = function (t, e, n, r) {
                    t.exception = t.exception || {}, t.exception.values = t.exception.values || [], t.exception.values[0] = t.exception.values[0] || {}, t.exception.values[0].stacktrace = t.exception.values[0].stacktrace || {}, t.exception.values[0].stacktrace.frames = t.exception.values[0].stacktrace.frames || [];
                    var o = isNaN(parseInt(r, 10)) ? void 0 : r, i = isNaN(parseInt(n, 10)) ? void 0 : n,
                        a = Vt(e) && 0 < e.length ? e : function () {
                            try {
                                return document.location.href
                            } catch (t) {
                                return ""
                            }
                        }();
                    return 0 === t.exception.values[0].stacktrace.frames.length && t.exception.values[0].stacktrace.frames.push({
                        colno: o,
                        filename: a,
                        function: "?",
                        in_app: !0,
                        lineno: i
                    }), t
                }, fr.id = "GlobalHandlers", fr);

                function fr(t) {
                    this.name = fr.id, this._global = ne(), this._oldOnErrorHandler = null, this._oldOnUnhandledRejectionHandler = null, this._onErrorHandlerInstalled = !1, this._onUnhandledRejectionHandlerInstalled = !1, this._options = c({
                        onerror: !0,
                        onunhandledrejection: !0
                    }, t)
                }

                var vr = (_r.prototype._wrapTimeFunction = function (t) {
                    return function () {
                        for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                        var r = e[0];
                        return e[0] = hr(r, {
                            mechanism: {
                                data: {function: fe(t)},
                                handled: !0,
                                type: "instrument"
                            }
                        }), t.apply(this, e)
                    }
                }, _r.prototype._wrapRAF = function (t) {
                    return function (e) {
                        return t(hr(e, {
                            mechanism: {
                                data: {function: "requestAnimationFrame", handler: fe(t)},
                                handled: !0,
                                type: "instrument"
                            }
                        }))
                    }
                }, _r.prototype._wrapEventTarget = function (t) {
                    var e = ne(), n = e[t] && e[t].prototype;
                    n && n.hasOwnProperty && n.hasOwnProperty("addEventListener") && (Oe(n, "addEventListener", (function (e) {
                        return function (n, r, o) {
                            try {
                                "function" == typeof r.handleEvent && (r.handleEvent = hr(r.handleEvent.bind(r), {
                                    mechanism: {
                                        data: {
                                            function: "handleEvent",
                                            handler: fe(r),
                                            target: t
                                        }, handled: !0, type: "instrument"
                                    }
                                }))
                            } catch (n) {
                            }
                            return e.call(this, n, hr(r, {
                                mechanism: {
                                    data: {
                                        function: "addEventListener",
                                        handler: fe(r),
                                        target: t
                                    }, handled: !0, type: "instrument"
                                }
                            }), o)
                        }
                    })), Oe(n, "removeEventListener", (function (t) {
                        return function (e, n, r) {
                            var o = n;
                            try {
                                o = o && (o.__sentry_wrapped__ || o)
                            } catch (e) {
                            }
                            return t.call(this, e, o, r)
                        }
                    })))
                }, _r.prototype._wrapXHR = function (t) {
                    return function () {
                        for (var e = this, n = [], r = 0; r < arguments.length; r++) n[r] = arguments[r];
                        return ["onload", "onerror", "onprogress"].forEach((function (t) {
                            t in e && "function" == typeof e[t] && Oe(e, t, (function (e) {
                                return hr(e, {
                                    mechanism: {
                                        data: {function: t, handler: fe(e)},
                                        handled: !0,
                                        type: "instrument"
                                    }
                                })
                            }))
                        })), "onreadystatechange" in this && "function" == typeof this.onreadystatechange && Oe(this, "onreadystatechange", (function (t) {
                            var e = {
                                mechanism: {
                                    data: {function: "onreadystatechange", handler: fe(t)},
                                    handled: !0,
                                    type: "instrument"
                                }
                            };
                            return t.__sentry_original__ && (e.mechanism.data.handler = fe(t.__sentry_original__)), hr(t, e)
                        })), t.apply(this, n)
                    }
                }, _r.prototype.setupOnce = function () {
                    this._ignoreOnError = this._ignoreOnError;
                    var t = ne();
                    Oe(t, "setTimeout", this._wrapTimeFunction.bind(this)), Oe(t, "setInterval", this._wrapTimeFunction.bind(this)), Oe(t, "requestAnimationFrame", this._wrapRAF.bind(this)), "XMLHttpRequest" in t && Oe(XMLHttpRequest.prototype, "send", this._wrapXHR.bind(this)), ["EventTarget", "Window", "Node", "ApplicationCache", "AudioTrackList", "ChannelMergerNode", "CryptoOperation", "EventSource", "FileReader", "HTMLUnknownElement", "IDBDatabase", "IDBRequest", "IDBTransaction", "KeyOperation", "MediaController", "MessagePort", "ModalWindow", "Notification", "SVGElementInstance", "Screen", "TextTrack", "TextTrackCue", "TextTrackList", "WebSocket", "WebSocketWorker", "Worker", "XMLHttpRequest", "XMLHttpRequestEventTarget", "XMLHttpRequestUpload"].forEach(this._wrapEventTarget.bind(this))
                }, _r.id = "TryCatch", _r);

                function _r() {
                    this._ignoreOnError = 0, this.name = _r.id
                }

                var mr = (gr.prototype._consoleBreadcrumb = function (t) {
                    var e = {
                        category: "console",
                        data: {extra: {arguments: Re(t.args, 3)}, logger: "console"},
                        level: Tt.fromString(t.level),
                        message: ke(t.args, " ")
                    };
                    if ("assert" === t.level) {
                        if (!1 !== t.args[0]) return;
                        e.message = "Assertion failed: " + (ke(t.args.slice(1), " ") || "console.assert"), e.data.extra.arguments = Re(t.args.slice(1), 3)
                    }
                    sn().addBreadcrumb(e, {input: t.args, level: t.level})
                }, gr.prototype._domBreadcrumb = function (t) {
                    var e;
                    try {
                        e = t.event.target ? ue(t.event.target) : ue(t.event)
                    } catch (t) {
                        e = "<unknown>"
                    }
                    0 !== e.length && sn().addBreadcrumb({category: "ui." + t.name, message: e}, {
                        event: event,
                        name: t.name
                    })
                }, gr.prototype._xhrBreadcrumb = function (t) {
                    if (t.endTimestamp) {
                        if (t.xhr.__sentry_own_request__) return;
                        sn().addBreadcrumb({category: "xhr", data: t.xhr.__sentry_xhr__, type: "http"}, {xhr: t.xhr})
                    } else t.xhr.__sentry_own_request__ && yr(t.args[0])
                }, gr.prototype._fetchBreadcrumb = function (t) {
                    if (t.endTimestamp) {
                        var e = sn().getClient(), n = e && e.getDsn();
                        if (n) {
                            var r = new _n(n).getStoreEndpoint();
                            if (r && -1 !== t.fetchData.url.indexOf(r) && "POST" === t.fetchData.method && t.args[1] && t.args[1].body) return void yr(t.args[1].body)
                        }
                        t.error ? sn().addBreadcrumb({
                            category: "fetch",
                            data: c({}, t.fetchData, {status_code: t.response.status}),
                            level: Tt.Error,
                            type: "http"
                        }, {data: t.error, input: t.args}) : sn().addBreadcrumb({
                            category: "fetch",
                            data: c({}, t.fetchData, {status_code: t.response.status}),
                            type: "http"
                        }, {input: t.args, response: t.response})
                    }
                }, gr.prototype._historyBreadcrumb = function (t) {
                    var e = ne(), n = t.from, r = t.to, o = oe(e.location.href), i = oe(n), a = oe(r);
                    i.path || (i = o), o.protocol === a.protocol && o.host === a.host && (r = a.relative), o.protocol === i.protocol && o.host === i.host && (n = i.relative), sn().addBreadcrumb({
                        category: "navigation",
                        data: {from: n, to: r}
                    })
                }, gr.prototype.setupOnce = function () {
                    var t = this;
                    this._options.console && Be({
                        callback: function () {
                            for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                            t._consoleBreadcrumb.apply(t, p(e))
                        }, type: "console"
                    }), this._options.dom && Be({
                        callback: function () {
                            for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                            t._domBreadcrumb.apply(t, p(e))
                        }, type: "dom"
                    }), this._options.xhr && Be({
                        callback: function () {
                            for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                            t._xhrBreadcrumb.apply(t, p(e))
                        }, type: "xhr"
                    }), this._options.fetch && Be({
                        callback: function () {
                            for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                            t._fetchBreadcrumb.apply(t, p(e))
                        }, type: "fetch"
                    }), this._options.history && Be({
                        callback: function () {
                            for (var e = [], n = 0; n < arguments.length; n++) e[n] = arguments[n];
                            t._historyBreadcrumb.apply(t, p(e))
                        }, type: "history"
                    })
                }, gr.id = "Breadcrumbs", gr);

                function gr(t) {
                    this.name = gr.id, this._options = c({
                        console: !0,
                        dom: !0,
                        fetch: !0,
                        history: !0,
                        sentry: !0,
                        xhr: !0
                    }, t)
                }

                function yr(t) {
                    try {
                        var e = JSON.parse(t);
                        sn().addBreadcrumb({
                            category: "sentry",
                            event_id: e.event_id,
                            level: e.level || Tt.fromString("error"),
                            message: ie(e)
                        }, {event: e})
                    } catch (t) {
                        we.error("Error while adding sentry type breadcrumb")
                    }
                }

                var br = (wr.prototype.setupOnce = function () {
                    en((function (t, e) {
                        var n = sn().getIntegration(wr);
                        return n ? n._handler(t, e) : t
                    }))
                }, wr.prototype._handler = function (t, e) {
                    if (!(t.exception && t.exception.values && e && Zt(e.originalException, Error))) return t;
                    var n = this._walkErrorTree(e.originalException, this._key);
                    return t.exception.values = p(n, t.exception.values), t
                }, wr.prototype._walkErrorTree = function (t, e, n) {
                    if (void 0 === n && (n = []), !Zt(t[e], Error) || n.length + 1 >= this._limit) return n;
                    var r = Fn(An(t[e]));
                    return this._walkErrorTree(t[e], e, p([r], n))
                }, wr.id = "LinkedErrors", wr);

                function wr(t) {
                    void 0 === t && (t = {}), this.name = wr.id, this._key = t.key || "cause", this._limit = t.limit || 5
                }

                var Er = ne(), Sr = (xr.prototype.setupOnce = function () {
                    en((function (t) {
                        if (sn().getIntegration(xr)) {
                            if (!Er.navigator || !Er.location) return t;
                            var e = t.request || {};
                            return e.url = e.url || Er.location.href, e.headers = e.headers || {}, e.headers["User-Agent"] = Er.navigator.userAgent, c({}, t, {request: e})
                        }
                        return t
                    }))
                }, xr.id = "UserAgent", xr);

                function xr() {
                    this.name = xr.id
                }

                var kr = Object.freeze({
                    __proto__: null,
                    GlobalHandlers: dr,
                    TryCatch: vr,
                    Breadcrumbs: mr,
                    LinkedErrors: br,
                    UserAgent: Sr
                }), Tr = [new Cn, new Tn, new vr, new mr, new dr, new br, new Sr];

                function Or(t) {
                    if (void 0 === t && (t = {}), void 0 === t.defaultIntegrations && (t.defaultIntegrations = Tr), void 0 === t.release) {
                        var e = ne();
                        e.SENTRY_RELEASE && e.SENTRY_RELEASE.id && (t.release = e.SENTRY_RELEASE.id)
                    }
                    var n, r;
                    n = cr, !0 === (r = t).debug && we.enable(), sn().bindClient(new n(r))
                }

                var jr = {}, Cr = ne();
                Cr.Sentry && Cr.Sentry.Integrations && (jr = Cr.Sentry.Integrations);
                var Rr = c({}, jr, Ln, kr), Lr = Object.freeze({
                    __proto__: null,
                    Integrations: Rr,
                    Transports: nr,
                    get Severity() {
                        return Tt
                    },
                    get Status() {
                        return Pt
                    },
                    addGlobalEventProcessor: en,
                    addBreadcrumb: function (t) {
                        pn("addBreadcrumb", t)
                    },
                    captureException: hn,
                    captureEvent: function (t) {
                        return pn("captureEvent", t)
                    },
                    captureMessage: dn,
                    configureScope: fn,
                    getHubFromCarrier: un,
                    getCurrentHub: sn,
                    Hub: nn,
                    Scope: Qe,
                    setContext: function (t, e) {
                        pn("setContext", t, e)
                    },
                    setExtra: function (t, e) {
                        pn("setExtra", t, e)
                    },
                    setExtras: function (t) {
                        pn("setExtras", t)
                    },
                    setTag: function (t, e) {
                        pn("setTag", t, e)
                    },
                    setTags: function (t) {
                        pn("setTags", t)
                    },
                    setUser: function (t) {
                        pn("setUser", t)
                    },
                    withScope: vn,
                    BrowserClient: cr,
                    defaultIntegrations: Tr,
                    forceLoad: function () {
                    },
                    init: Or,
                    lastEventId: function () {
                        return sn().lastEventId()
                    },
                    onLoad: function (t) {
                        t()
                    },
                    showReportDialog: function (t) {
                        void 0 === t && (t = {}), t.eventId || (t.eventId = sn().lastEventId());
                        var e = sn().getClient();
                        e && e.showReportDialog(t)
                    },
                    flush: function (t) {
                        var e = sn().getClient();
                        return e ? e.flush(t) : Le.reject(!1)
                    },
                    close: function (t) {
                        var e = sn().getClient();
                        return e ? e.close(t) : Le.reject(!1)
                    },
                    wrap: function (t) {
                        return hr(t)()
                    },
                    SDK_NAME: ar,
                    SDK_VERSION: sr
                }), Pr = window.Slardar && window.Slardar.shared || {}, Mr = [], Dr = function () {
                    for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
                    t && t[0] && Mr.push(t[0])
                };

                function Ir(t) {
                    var e = {};
                    Pr.config && h(Pr.config) && h(Pr.config.plugins) && (e = Pr.config.plugins), e && e.sentry && e.sentry.enable && (t(e), window.Sentry = Lr)
                }

                !function (t) {
                    if (d(window.addEventListener) && "npm" !== Pr.installedType && window.addEventListener("error", Dr), "script" === Pr.installedType) return Ir(t);
                    if ("npm" === Pr.installedType) {
                        if ("async" === Pr.pluginsLoadType) return Ir(t);
                        Pr.emitter && Pr.emitter.on("pluginsReady", (function () {
                            Ir(t)
                        }))
                    }
                }((function (t) {
                    var e = t.sentry || {}, n = function () {
                    };
                    if (d(e.beforeSend) && (n = e.beforeSend, delete e.beforeSend), Or(c({
                        dsn: "https://key@i.snssdk.com/log/sentry/v2/slardar",
                        beforeSend: function (t) {
                            d(n) && n(t);
                            var e = {ev_type: "jserr", sentry: t};
                            return Pr.sendEvent && d(Pr.sendEvent) && (Pr.emitter && Pr.emitter.emit("event_id", t.event_id), Pr.sendEvent({
                                event: e,
                                type: "post",
                                name: "SentryPlugin"
                            })), null
                        }
                    }, e)), e.tags) {
                        var r = e.tags, o = function (t) {
                            Object.prototype.hasOwnProperty.call(r, t) && fn((function (e) {
                                e.setTag(t, r[t])
                            }))
                        };
                        for (var i in r) o(i)
                    }
                    if (Mr.forEach((function (t) {
                        "error" === t.type && (t.error ? hn(t.error) : t.message && dn(t.message))
                    })), d(window.removeEventListener) && window.removeEventListener("error", Dr), Pr.collect && v(Pr.collect.Sentry) && k(Pr.collect.Sentry, (function (t, e) {
                        d(e) && e(Lr)
                    })), window.Slardar && window.Slardar.shared) {
                        var a = Pr.plugins || {};
                        a.sentry = Lr, window.Slardar.shared.plugins = a
                    }
                })), function (t) {
                    if (!t.WeakMap) {
                        var e = Object.prototype.hasOwnProperty, n = function (t, e, n) {
                            Object.defineProperty ? Object.defineProperty(t, e, {
                                configurable: !0,
                                writable: !0,
                                value: n
                            }) : t[e] = n
                        };
                        t.WeakMap = (n(r.prototype, "delete", (function (t) {
                            if (i(this, "delete"), !s(t)) return !1;
                            var e = t[this._id];
                            return !(!e || e[0] !== t || (delete t[this._id], 0))
                        })), n(r.prototype, "get", (function (t) {
                            if (i(this, "get"), s(t)) {
                                var e = t[this._id];
                                return e && e[0] === t ? e[1] : void 0
                            }
                        })), n(r.prototype, "has", (function (t) {
                            if (i(this, "has"), !s(t)) return !1;
                            var e = t[this._id];
                            return !(!e || e[0] !== t)
                        })), n(r.prototype, "set", (function (t, e) {
                            if (i(this, "set"), !s(t)) throw new TypeError("Invalid value used as weak map key");
                            var r = t[this._id];
                            return r && r[0] === t ? r[1] = e : n(t, this._id, [t, e]), this
                        })), n(r, "_polyfill", !0), r)
                    }

                    function r() {
                        if (void 0 === this) throw new TypeError("Constructor WeakMap requires 'new'");
                        if (n(this, "_id", "_WeakMap_" + a() + "." + a()), 0 < arguments.length) throw new TypeError("WeakMap iterable is not supported")
                    }

                    function i(t, n) {
                        if (!s(t) || !e.call(t, "_id")) throw new TypeError(n + " method called on incompatible receiver " + o(t))
                    }

                    function a() {
                        return Math.random().toString().substring(2)
                    }

                    function s(t) {
                        return Object(t) === t
                    }
                }("undefined" != typeof self ? self : "undefined" != typeof window ? window : void 0 !== n ? n : null), window.NodeList && !NodeList.prototype.forEach && (NodeList.prototype.forEach = Array.prototype.forEach), function (t) {
                    "MutationObserver" in this || (window.MutationObserver = window.MutationObserver || function (t) {
                        function e(t) {
                            this._watched = [], this._listener = t
                        }

                        function n(e) {
                            var n = {
                                type: null,
                                target: null,
                                addedNodes: [],
                                removedNodes: [],
                                previousSibling: null,
                                nextSibling: null,
                                attributeName: null,
                                attributeNamespace: null,
                                oldValue: null
                            };
                            for (var r in e) u(n, r) && e[r] !== t && (n[r] = e[r]);
                            return n
                        }

                        function r(e, r) {
                            var s = i(e, r);
                            return function (u) {
                                var l, p, h, d, f = u.length;

                                function v(t, e, r, i, a) {
                                    for (var s, c, u, l = t.length - 1, d = -~((l - a) / 2); u = t.pop();) s = r[u.i], c = i[u.j], h.kids && d && Math.abs(u.i - u.j) >= l && (p.push(n({
                                        type: "childList",
                                        target: e,
                                        addedNodes: [s],
                                        removedNodes: [s],
                                        nextSibling: s.nextSibling,
                                        previousSibling: s.previousSibling
                                    })), d--), h.attr && c.attr && o(p, s, c.attr, h.afilter), h.charData && 3 === s.nodeType && s.nodeValue !== c.charData && p.push(n({
                                        type: "characterData",
                                        target: s,
                                        oldValue: c.charData
                                    })), h.descendents && _(s, c)
                                }

                                function _(e, r) {
                                    for (var i, s, u, l, f, m, g, y = e.childNodes, b = r.kids, w = y.length, E = b ? b.length : 0, S = 0, x = 0, k = 0; x < w || k < E;) (m = y[x]) === (g = (f = b[k]) && f.node) ? (h.attr && f.attr && o(p, m, f.attr, h.afilter), h.charData && f.charData !== t && m.nodeValue !== f.charData && p.push(n({
                                        type: "characterData",
                                        target: m,
                                        oldValue: f.charData
                                    })), s && v(s, e, y, b, S), h.descendents && (m.childNodes.length || f.kids && f.kids.length) && _(m, f), x++, k++) : (d = !0, i || (i = {}, s = []), m && (i[u = a(m)] || (i[u] = !0, -1 === (l = c(b, m, k, "node")) ? h.kids && (p.push(n({
                                        type: "childList",
                                        target: e,
                                        addedNodes: [m],
                                        nextSibling: m.nextSibling,
                                        previousSibling: m.previousSibling
                                    })), S++) : s.push({
                                        i: x,
                                        j: l
                                    })), x++), g && g !== y[x] && (i[u = a(g)] || (i[u] = !0, -1 === (l = c(y, g, x)) ? h.kids && (p.push(n({
                                        type: "childList",
                                        target: r.node,
                                        removedNodes: [g],
                                        nextSibling: b[k + 1],
                                        previousSibling: b[k - 1]
                                    })), S--) : s.push({i: l, j: k})), k++));
                                    s && v(s, e, y, b, S)
                                }

                                r.charData && 3 === e.nodeType && e.nodeValue !== s.charData && u.push(new n({
                                    type: "characterData",
                                    target: e,
                                    oldValue: s.charData
                                })), r.attr && s.attr && o(u, e, s.attr, r.afilter), (r.kids || r.descendents) && (p = u, h = r, _(e, s), l = d), !l && u.length === f || (s = i(e, r))
                            }
                        }

                        function o(t, e, r, o) {
                            for (var i, a, s = {}, c = e.attributes, l = c.length; l--;) a = (i = c[l]).name, o && !u(o, a) || (p(e, i) !== r[a] && t.push(n({
                                type: "attributes",
                                target: e,
                                attributeName: a,
                                oldValue: r[a],
                                attributeNamespace: i.namespaceURI
                            })), s[a] = !0);
                            for (a in r) s[a] || t.push(n({
                                target: e,
                                type: "attributes",
                                attributeName: a,
                                oldValue: r[a]
                            }))
                        }

                        function i(t, e) {
                            var n = !0;
                            return function t(r) {
                                var o = {node: r};
                                return !e.charData || 3 !== r.nodeType && 8 !== r.nodeType ? (e.attr && n && 1 === r.nodeType && (o.attr = s(r.attributes, (function (t, n) {
                                    return e.afilter && !e.afilter[n.name] || (t[n.name] = p(r, n)), t
                                }), {})), n && (e.kids || e.charData || e.attr && e.descendents) && (o.kids = function (t, e) {
                                    for (var n = [], r = 0; r < t.length; r++) n[r] = e(t[r], r, t);
                                    return n
                                }(r.childNodes, t)), n = e.descendents) : o.charData = r.nodeValue, o
                            }(t)
                        }

                        function a(t) {
                            try {
                                return t.id || (t[d] = t[d] || h++)
                            } catch (e) {
                                try {
                                    return t.nodeValue
                                } catch (t) {
                                    return h++
                                }
                            }
                        }

                        function s(t, e, n) {
                            for (var r = 0; r < t.length; r++) n = e(n, t[r], r, t);
                            return n
                        }

                        function c(t, e, n, r) {
                            for (; n < t.length; n++) if ((r ? t[n][r] : t[n]) === e) return n;
                            return -1
                        }

                        function u(e, n) {
                            return e[n] !== t
                        }

                        e._period = 30, e.prototype = {
                            observe: function (t, n) {
                                for (var o = {
                                    attr: !!(n.attributes || n.attributeFilter || n.attributeOldValue),
                                    kids: !!n.childList,
                                    descendents: !!n.subtree,
                                    charData: !(!n.characterData && !n.characterDataOldValue)
                                }, i = this._watched, a = 0; a < i.length; a++) i[a].tar === t && i.splice(a, 1);
                                var c;
                                n.attributeFilter && (o.afilter = s(n.attributeFilter, (function (t, e) {
                                    return t[e] = !0, t
                                }), {})), i.push({tar: t, fn: r(t, o)}), this._timeout || (c = this, function t() {
                                    var n = c.takeRecords();
                                    n.length && c._listener(n, c), c._timeout = setTimeout(t, e._period)
                                }())
                            }, takeRecords: function () {
                                for (var t = [], e = this._watched, n = 0; n < e.length; n++) e[n].fn(t);
                                return t
                            }, disconnect: function () {
                                this._watched = [], clearTimeout(this._timeout), this._timeout = null
                            }
                        };
                        var l = document.createElement("i");
                        l.style.top = 0;
                        var p = (l = "null" != l.attributes.style.value) ? function (t, e) {
                            return e.value
                        } : function (t, e) {
                            return "style" !== e.name ? e.value : t.style.cssText
                        }, h = 1, d = "mo_id";
                        return e
                    }(void 0))
                }.call("object" === ("undefined" == typeof window ? "undefined" : o(window)) && window || "object" === ("undefined" == typeof self ? "undefined" : o(self)) && self || "object" === (void 0 === n ? "undefined" : o(n)) && n || {});
                var Nr, Ar, Ur = function () {
                    return (Ur = Object.assign || function (t) {
                        for (var e, n = 1, r = arguments.length; n < r; n++) for (var o in e = arguments[n]) Object.prototype.hasOwnProperty.call(e, o) && (t[o] = e[o]);
                        return t
                    }).apply(this, arguments)
                };
                (Ar = Nr = Nr || {})[Ar.Document = 0] = "Document", Ar[Ar.DocumentType = 1] = "DocumentType", Ar[Ar.Element = 2] = "Element", Ar[Ar.Text = 3] = "Text", Ar[Ar.CDATA = 4] = "CDATA", Ar[Ar.Comment = 5] = "Comment";
                var Hr = 1;

                function Fr(t) {
                    try {
                        var e = t.rules || t.cssRules;
                        return e ? Array.from(e).reduce((function (t, e) {
                            return t + (function (t) {
                                return "styleSheet" in t
                            }(n = e) ? Fr(n.styleSheet) || "" : n.cssText);
                            var n
                        }), "") : null
                    } catch (t) {
                        return null
                    }
                }

                var Br = /url\((?:'([^']*)'|"([^"]*)"|([^)]*))\)/gm,
                    qr = /^(?!www\.|(?:http|ftp)s?:\/\/|[A-Za-z]:\\|\/\/).*/,
                    Wr = /^(data:)([\w\/\+\-]+);(charset=[\w-]+|base64).*,(.*)/i;

                function Xr(t, e) {
                    return t.replace(Br, (function (t, n, r, o) {
                        var i, a = n || r || o;
                        if (!a) return t;
                        if (!qr.test(a)) return "url('" + a + "')";
                        if (Wr.test(a)) return "url(" + a + ")";
                        if ("/" === a[0]) return "url('" + ((-1 < (i = e).indexOf("//") ? i.split("/").slice(0, 3).join("/") : i.split("/")[0]).split("?")[0] + a) + "')";
                        var s = e.split("/"), c = a.split("/");
                        s.pop();
                        for (var u = 0, l = c; u < l.length; u++) {
                            var p = l[u];
                            "." !== p && (".." === p ? s.pop() : s.push(p))
                        }
                        return "url('" + s.join("/") + "')"
                    }))
                }

                function Yr(t, e, n, r, o, a, s) {
                    void 0 === o && (o = !1), void 0 === a && (a = !0), void 0 === s && (s = !1);
                    var c, u = function (t, e, n, r, o) {
                        switch (t.nodeType) {
                            case t.DOCUMENT_NODE:
                                return {type: Nr.Document, childNodes: []};
                            case t.DOCUMENT_TYPE_NODE:
                                return {
                                    type: Nr.DocumentType,
                                    name: t.name,
                                    publicId: t.publicId,
                                    systemId: t.systemId
                                };
                            case t.ELEMENT_NODE:
                                var i = !1;
                                "string" == typeof n ? i = t.classList.contains(n) : t.classList.forEach((function (t) {
                                    n.test(t) && (i = !0)
                                }));
                                for (var a = t.tagName.toLowerCase(), s = {}, c = 0, u = Array.from(t.attributes); c < u.length; c++) {
                                    var l = u[c], p = l.name, h = l.value;
                                    s[p] = "src" === p || "href" === p ? (S = h, x = void 0, (x = e.createElement("a")).href = S, x.href) : "style" === p ? Xr(h, location.href) : h
                                }
                                if ("link" === a && r) {
                                    var d, f = Array.from(e.styleSheets).find((function (e) {
                                        return e.href === t.href
                                    }));
                                    (d = Fr(f)) && (delete s.rel, delete s.href, s._cssText = Xr(d, f.href))
                                }
                                if ("style" === a && t.sheet && !(t.innerText || t.textContent || "").trim().length && (d = Fr(t.sheet)) && (s._cssText = Xr(d, location.href)), "input" !== a && "textarea" !== a && "select" !== a || (h = t.value, "radio" !== s.type && "checkbox" !== s.type && h ? s.value = o ? "*".repeat(h.length) : h : t.checked && (s.checked = t.checked)), "option" === a) {
                                    var v = t.parentElement;
                                    s.value === v.value && (s.selected = t.selected)
                                }
                                if (i) {
                                    var _ = t.getBoundingClientRect(), m = _.width, g = _.height;
                                    s.rr_width = m + "px", s.rr_height = g + "px"
                                }
                                return {
                                    type: Nr.Element,
                                    tagName: a,
                                    attributes: s,
                                    childNodes: [],
                                    isSVG: "svg" === (E = t).tagName || E instanceof SVGElement || void 0,
                                    needBlock: i
                                };
                            case t.TEXT_NODE:
                                var y = t.parentNode && t.parentNode.tagName, b = t.textContent,
                                    w = "STYLE" === y || void 0;
                                return w && b && (b = Xr(b, location.href)), "SCRIPT" === y && (b = "SCRIPT_PLACEHOLDER"), {
                                    type: Nr.Text,
                                    textContent: b || "",
                                    isStyle: w
                                };
                            case t.CDATA_SECTION_NODE:
                                return {type: Nr.CDATA, textContent: ""};
                            case t.COMMENT_NODE:
                                return {type: Nr.Comment, textContent: t.textContent || ""};
                            default:
                                return !1
                        }
                        var E, S, x
                    }(t, e, r, a, s);
                    if (!u) return console.warn(t, "not serialized"), null;
                    var l = i(u, {id: c = "__sn" in t ? t.__sn.id : Hr++});
                    t.__sn = l, n[c] = t;
                    var p = !o;
                    if (l.type === Nr.Element && (p = p && !l.needBlock, delete l.needBlock), (l.type === Nr.Document || l.type === Nr.Element) && p) for (var h = 0, d = Array.from(t.childNodes); h < d.length; h++) {
                        var f = Yr(d[h], e, n, r, o, a, s);
                        f && l.childNodes.push(f)
                    }
                    return l
                }

                function zr(t, e, n) {
                    void 0 === n && (n = document);
                    var r = {capture: !0, passive: !0};
                    return n.addEventListener(t, e, r), function () {
                        return n.removeEventListener(t, e, r)
                    }
                }

                var Vr, Jr, Gr, $r, Kr, Qr, Zr, to, eo = {
                    map: {}, getId: function (t) {
                        return t && t.__sn ? t.__sn.id : -1
                    }, getNode: function (t) {
                        return eo.map[t] || null
                    }, removeNodeFromMap: function (t) {
                        var e = t.__sn && t.__sn.id;
                        delete eo.map[e], t.childNodes && t.childNodes.forEach((function (t) {
                            return eo.removeNodeFromMap(t)
                        }))
                    }, has: function (t) {
                        return eo.map.hasOwnProperty(t)
                    }
                };

                function no(t, e, n) {
                    void 0 === n && (n = {});
                    var r = null, o = 0;
                    return function () {
                        var i = Date.now();
                        o || !1 !== n.leading || (o = i);
                        var a = e - (i - o), s = this, c = arguments;
                        a <= 0 || e < a ? (r && (window.clearTimeout(r), r = null), o = i, t.apply(s, c)) : r || !1 === n.trailing || (r = window.setTimeout((function () {
                            o = !1 === n.leading ? 0 : Date.now(), r = null, t.apply(s, c)
                        }), a))
                    }
                }

                function ro() {
                    return window.innerHeight || document.documentElement && document.documentElement.clientHeight || document.body && document.body.clientHeight
                }

                function oo() {
                    return window.innerWidth || document.documentElement && document.documentElement.clientWidth || document.body && document.body.clientWidth
                }

                function io(t, e) {
                    if (!t) return !1;
                    if (t.nodeType !== t.ELEMENT_NODE) return io(t.parentNode, e);
                    var n = !1;
                    return "string" == typeof e ? n = t.classList.contains(e) : t.classList.forEach((function (t) {
                        e.test(t) && (n = !0)
                    })), n || io(t.parentNode, e)
                }

                function ao(t) {
                    return Boolean(t.changedTouches)
                }

                function so(t, e) {
                    t.delete(e), e.childNodes.forEach((function (e) {
                        return so(t, e)
                    }))
                }

                function co(t, e) {
                    var n = e.parentNode;
                    return !!n && (!!t.has(n) || co(t, n))
                }

                (Jr = Vr = Vr || {})[Jr.DomContentLoaded = 0] = "DomContentLoaded", Jr[Jr.Load = 1] = "Load", Jr[Jr.FullSnapshot = 2] = "FullSnapshot", Jr[Jr.IncrementalSnapshot = 3] = "IncrementalSnapshot", Jr[Jr.Meta = 4] = "Meta", ($r = Gr = Gr || {})[$r.Mutation = 0] = "Mutation", $r[$r.MouseMove = 1] = "MouseMove", $r[$r.MouseInteraction = 2] = "MouseInteraction", $r[$r.Scroll = 3] = "Scroll", $r[$r.ViewportResize = 4] = "ViewportResize", $r[$r.Input = 5] = "Input", (Qr = Kr = Kr || {})[Qr.MouseUp = 0] = "MouseUp", Qr[Qr.MouseDown = 1] = "MouseDown", Qr[Qr.Click = 2] = "Click", Qr[Qr.ContextMenu = 3] = "ContextMenu", Qr[Qr.DblClick = 4] = "DblClick", Qr[Qr.Focus = 5] = "Focus", Qr[Qr.Blur = 6] = "Blur", Qr[Qr.TouchStart = 7] = "TouchStart", Qr[Qr.TouchMove_Departed = 8] = "TouchMove_Departed", Qr[Qr.TouchEnd = 9] = "TouchEnd", (to = Zr = Zr || {}).Start = "start", to.Pause = "pause", to.Resume = "resume", to.Resize = "resize", to.Finish = "finish", to.FullsnapshotRebuilded = "fullsnapshot-rebuilded", to.LoadStylesheetStart = "load-stylesheet-start", to.LoadStylesheetEnd = "load-stylesheet-end", to.SkipStart = "skip-start", to.SkipEnd = "skip-end", to.MouseInteraction = "mouse-interaction";
                var uo = function (t, e) {
                    return t + "@" + e
                };

                function lo(t) {
                    return "__sn" in t
                }

                var po, ho, fo, vo, _o, mo = ["INPUT", "TEXTAREA", "SELECT"],
                    go = ["color", "date", "datetime-local", "email", "month", "number", "range", "search", "tel", "text", "time", "url", "week"],
                    yo = null, bo = function () {
                        return yo = yo || new WeakMap
                    };

                function wo(t) {
                    var e, n, r, o, i, a, s, c, u, l = function (t, e, n, r) {
                            var o = new MutationObserver((function (o) {
                                var i = [], a = [], s = [], c = [], u = new Set, l = new Set, p = new Set, h = {};

                                function d(t) {
                                    var o = eo.getId(t.parentNode);
                                    if (-1 === o) return f.push(t);
                                    c.push({
                                        parentId: o,
                                        previousId: t.previousSibling ? eo.getId(t.previousSibling) : t.previousSibling,
                                        nextId: t.nextSibling ? eo.getId(t.nextSibling) : t.nextSibling,
                                        node: Yr(t, document, eo.map, e, !0, n, r)
                                    })
                                }

                                o.forEach((function (t) {
                                    var n = t.type, r = t.target, o = t.oldValue, c = t.addedNodes, d = t.removedNodes,
                                        f = t.attributeName;
                                    switch (n) {
                                        case"characterData":
                                            var v = r.textContent;
                                            io(r, e) || v === o || i.push({value: v, node: r});
                                            break;
                                        case"attributes":
                                            if (v = r.getAttribute(f), io(r, e) || v === o) return;
                                            var _ = a.find((function (t) {
                                                return t.node === r
                                            }));
                                            _ || (_ = {node: r, attributes: {}}, a.push(_)), _.attributes[f] = v;
                                            break;
                                        case"childList":
                                            c.forEach((function (t) {
                                                return function t(n, r) {
                                                    if (!io(n, e)) {
                                                        if (lo(n)) {
                                                            l.add(n);
                                                            var o = null;
                                                            r && lo(r) && (o = r.__sn.id), o && (h[uo(n.__sn.id, o)] = !0)
                                                        } else u.add(n), p.delete(n);
                                                        n.childNodes.forEach((function (e) {
                                                            return t(e)
                                                        }))
                                                    }
                                                }(t, r)
                                            })), d.forEach((function (t) {
                                                var n = eo.getId(t), o = eo.getId(r);
                                                io(t, e) || (u.has(t) ? (so(u, t), p.add(t)) : u.has(r) && -1 === n || function t(e) {
                                                    var n = eo.getId(e);
                                                    return !eo.has(n) || (!e.parentNode || e.parentNode.nodeType !== e.DOCUMENT_NODE) && (!e.parentNode || t(e.parentNode))
                                                }(r) || (l.has(t) && h[uo(n, o)] ? so(l, t) : s.push({
                                                    parentId: o,
                                                    id: n
                                                })), eo.removeNodeFromMap(t))
                                            }))
                                    }
                                }));
                                var f = [];
                                for (Array.from(l).forEach(d), Array.from(u).forEach((function (t) {
                                    co(p, t) || function t(e, n) {
                                        var r = n.parentNode;
                                        if (!r) return !1;
                                        var o = eo.getId(r);
                                        return !!e.some((function (t) {
                                            return t.id === o
                                        })) || t(e, r)
                                    }(s, t) ? co(l, t) ? d(t) : p.add(t) : d(t)
                                })); f.length && !f.every((function (t) {
                                    return -1 === eo.getId(t.parentNode)
                                }));) d(f.shift());
                                var v = {
                                    texts: i.map((function (t) {
                                        return {id: eo.getId(t.node), value: t.value}
                                    })).filter((function (t) {
                                        return eo.has(t.id)
                                    })), attributes: a.map((function (t) {
                                        return {id: eo.getId(t.node), attributes: t.attributes}
                                    })).filter((function (t) {
                                        return eo.has(t.id)
                                    })), removes: s, adds: c
                                };
                                (v.texts.length || v.attributes.length || v.removes.length || v.adds.length) && t(v)
                            }));
                            return o.observe(document, {
                                attributes: !0,
                                attributeOldValue: !0,
                                characterData: !0,
                                characterDataOldValue: !0,
                                childList: !0,
                                subtree: !0
                            }), o
                        }(t.mutationCb, t.blockClass, t.inlineStylesheet, t.maskAllInputs),
                        p = (e = t.mousemoveCb, r = [], o = no((function () {
                            var t = Date.now() - n;
                            e(r.map((function (e) {
                                return e.timeOffset -= t, e
                            }))), r = [], n = null
                        }), 500), i = no((function (t) {
                            var e = t.target, i = ao(t) ? t.changedTouches[0] : t, a = i.clientX, s = i.clientY;
                            n = n || Date.now(), r.push({x: a, y: s, id: eo.getId(e), timeOffset: Date.now() - n}), o()
                        }), 50, {trailing: !1}), a = [zr("mousemove", i), zr("touchmove", i)], function () {
                            a.forEach((function (t) {
                                return t()
                            }))
                        }), h = function (t, e) {
                            var n = [];
                            return Object.keys(Kr).filter((function (t) {
                                return Number.isNaN(Number(t)) && !t.endsWith("_Departed")
                            })).forEach((function (r) {
                                var o, i = r.toLowerCase(), a = (o = r, function (n) {
                                    if (!io(n.target, e)) {
                                        var r = eo.getId(n.target), i = ao(n) ? n.changedTouches[0] : n, a = i.clientX,
                                            s = i.clientY;
                                        t({type: Kr[o], id: r, x: a, y: s})
                                    }
                                });
                                n.push(zr(i, a))
                            })), function () {
                                n.forEach((function (t) {
                                    return t()
                                }))
                            }
                        }(t.mouseInteractionCb, t.blockClass),
                        d = (s = t.scrollCb, c = t.blockClass, zr("scroll", no((function (t) {
                            if (t.target && !io(t.target, c)) {
                                var e = eo.getId(t.target);
                                if (t.target === document) {
                                    var n = document.scrollingElement || document.documentElement;
                                    s({id: e, x: n.scrollLeft, y: n.scrollTop})
                                } else s({id: e, x: t.target.scrollLeft, y: t.target.scrollTop})
                            }
                        }), 100))), f = (u = t.viewportResizeCb, zr("resize", no((function () {
                            var t = ro(), e = oo();
                            u({width: Number(e), height: Number(t)})
                        }), 200), window)), v = function (t, e, n, r) {
                            function o(t) {
                                var o = t.target;
                                if (o && o.tagName && !(mo.indexOf(o.tagName) < 0) && !io(o, e)) {
                                    var a = o.type;
                                    if ("password" !== a && !o.classList.contains(n)) {
                                        var s = o.value, c = !1, u = go.includes(a) || "TEXTAREA" === o.tagName;
                                        "radio" === a || "checkbox" === a ? c = o.checked : u && r && (s = "*".repeat(s.length)), i(o, {
                                            text: s,
                                            isChecked: c
                                        });
                                        var l = o.name;
                                        "radio" === a && l && c && document.querySelectorAll('input[type="radio"][name="' + l + '"]').forEach((function (t) {
                                            t !== o && i(t, {text: t.value, isChecked: !c})
                                        }))
                                    }
                                }
                            }

                            function i(e, n) {
                                var r = bo().get(e);
                                if (!r || r.text !== n.text || r.isChecked !== n.isChecked) {
                                    bo().set(e, n);
                                    var o = eo.getId(e);
                                    t(Ur({}, n, {id: o}))
                                }
                            }

                            var a = ["input", "change"].map((function (t) {
                                    return zr(t, o)
                                })), s = Object.getOwnPropertyDescriptor(HTMLInputElement.prototype, "value"),
                                c = [[HTMLInputElement.prototype, "value"], [HTMLInputElement.prototype, "checked"], [HTMLSelectElement.prototype, "value"], [HTMLTextAreaElement.prototype, "value"]];
                            return s && s.set && a.push.apply(a, c.map((function (t) {
                                return function t(e, n, r, o) {
                                    var i = Object.getOwnPropertyDescriptor(e, n);
                                    return Object.defineProperty(e, n, o ? r : {
                                        set: function (t) {
                                            var e = this;
                                            setTimeout((function () {
                                                r.set.call(e, t)
                                            }), 0), i && i.set && i.set.call(this, t)
                                        }
                                    }), function () {
                                        return t(e, n, i || {}, !0)
                                    }
                                }(t[0], t[1], {
                                    set: function () {
                                        o({target: this})
                                    }
                                })
                            }))), function () {
                                a.forEach((function (t) {
                                    return t()
                                }))
                            }
                        }(t.inputCb, t.blockClass, t.ignoreClass, t.maskAllInputs);
                    return function () {
                        l.disconnect(), p(), h(), d(), f(), v()
                    }
                }

                function Eo(t) {
                    return Ur({}, t, {timestamp: Date.now()})
                }

                function So(t) {
                    void 0 === t && (t = {});
                    var e, n = t.emit, r = t.checkoutEveryNms, o = t.checkoutEveryNth, i = t.blockClass,
                        a = void 0 === i ? "rr-block" : i, s = t.ignoreClass, c = void 0 === s ? "rr-ignore" : s,
                        u = t.inlineStylesheet, l = void 0 === u || u, p = t.maskAllInputs, h = void 0 !== p && p;
                    if (!n) throw new Error("emit function is required");
                    var d = 0, f = function (t, i) {
                        if (n(t, i), t.type === Vr.FullSnapshot) e = t, d = 0; else if (t.type === Vr.IncrementalSnapshot) {
                            d++;
                            var a = o && o <= d, s = r && t.timestamp - e.timestamp > r;
                            (a || s) && v(!0)
                        }
                    };

                    function v(t) {
                        void 0 === t && (t = !1), f(Eo({
                            type: Vr.Meta,
                            data: {href: window.location.href, width: oo(), height: ro()}
                        }), t);
                        var e = function (t, e, n, r) {
                            void 0 === e && (e = "rr-block"), void 0 === n && (n = !0), void 0 === r && (r = !1);
                            var o = {};
                            return [Yr(t, t, o, e, !1, n, r), o]
                        }(document, a, l, h), n = e[0], r = e[1];
                        if (!n) return console.warn("Failed to snapshot the document");
                        eo.map = r, f(Eo({
                            type: Vr.FullSnapshot,
                            data: {
                                node: n,
                                initialOffset: {
                                    left: document.documentElement.scrollLeft,
                                    top: document.documentElement.scrollTop
                                }
                            }
                        }))
                    }

                    try {
                        var _ = [];
                        _.push(zr("DOMContentLoaded", (function () {
                            f(Eo({type: Vr.DomContentLoaded, data: {}}))
                        })));
                        var m = function () {
                            v(), _.push(wo({
                                mutationCb: function (t) {
                                    return f(Eo({type: Vr.IncrementalSnapshot, data: Ur({source: Gr.Mutation}, t)}))
                                }, mousemoveCb: function (t) {
                                    return f(Eo({
                                        type: Vr.IncrementalSnapshot,
                                        data: {source: Gr.MouseMove, positions: t}
                                    }))
                                }, mouseInteractionCb: function (t) {
                                    return f(Eo({
                                        type: Vr.IncrementalSnapshot,
                                        data: Ur({source: Gr.MouseInteraction}, t)
                                    }))
                                }, scrollCb: function (t) {
                                    return f(Eo({type: Vr.IncrementalSnapshot, data: Ur({source: Gr.Scroll}, t)}))
                                }, viewportResizeCb: function (t) {
                                    return f(Eo({
                                        type: Vr.IncrementalSnapshot,
                                        data: Ur({source: Gr.ViewportResize}, t)
                                    }))
                                }, inputCb: function (t) {
                                    return f(Eo({type: Vr.IncrementalSnapshot, data: Ur({source: Gr.Input}, t)}))
                                }, blockClass: a, ignoreClass: c, maskAllInputs: h, inlineStylesheet: l
                            }))
                        };
                        return "interactive" === document.readyState || "complete" === document.readyState ? m() : _.push(zr("load", (function () {
                            f(Eo({type: Vr.Load, data: {}})), m()
                        }), window)), function () {
                            _.forEach((function (t) {
                                return t()
                            }))
                        }
                    } catch (t) {
                        console.warn(t)
                    }
                }

                (function (t, e) {
                    t.exports = {
                        polyfill: function () {
                            var t = window, e = document;
                            if (!("scrollBehavior" in e.documentElement.style && !0 !== t.__forceSmoothScrollPolyfill__)) {
                                var n, r = t.HTMLElement || t.Element, i = 468, a = {
                                        scroll: t.scroll || t.scrollTo,
                                        scrollBy: t.scrollBy,
                                        elementScroll: r.prototype.scroll || u,
                                        scrollIntoView: r.prototype.scrollIntoView
                                    },
                                    s = t.performance && t.performance.now ? t.performance.now.bind(t.performance) : Date.now,
                                    c = (n = t.navigator.userAgent, new RegExp(["MSIE ", "Trident/", "Edge/"].join("|")).test(n) ? 1 : 0);
                                t.scroll = t.scrollTo = function () {
                                    void 0 !== arguments[0] && (!0 !== l(arguments[0]) ? f.call(t, e.body, void 0 !== arguments[0].left ? ~~arguments[0].left : t.scrollX || t.pageXOffset, void 0 !== arguments[0].top ? ~~arguments[0].top : t.scrollY || t.pageYOffset) : a.scroll.call(t, void 0 !== arguments[0].left ? arguments[0].left : "object" !== o(arguments[0]) ? arguments[0] : t.scrollX || t.pageXOffset, void 0 !== arguments[0].top ? arguments[0].top : void 0 !== arguments[1] ? arguments[1] : t.scrollY || t.pageYOffset))
                                }, t.scrollBy = function () {
                                    void 0 !== arguments[0] && (l(arguments[0]) ? a.scrollBy.call(t, void 0 !== arguments[0].left ? arguments[0].left : "object" !== o(arguments[0]) ? arguments[0] : 0, void 0 !== arguments[0].top ? arguments[0].top : void 0 !== arguments[1] ? arguments[1] : 0) : f.call(t, e.body, ~~arguments[0].left + (t.scrollX || t.pageXOffset), ~~arguments[0].top + (t.scrollY || t.pageYOffset)))
                                }, r.prototype.scroll = r.prototype.scrollTo = function () {
                                    if (void 0 !== arguments[0]) if (!0 !== l(arguments[0])) {
                                        var t = arguments[0].left, e = arguments[0].top;
                                        f.call(this, this, void 0 === t ? this.scrollLeft : ~~t, void 0 === e ? this.scrollTop : ~~e)
                                    } else {
                                        if ("number" == typeof arguments[0] && void 0 === arguments[1]) throw new SyntaxError("Value could not be converted");
                                        a.elementScroll.call(this, void 0 !== arguments[0].left ? ~~arguments[0].left : "object" !== o(arguments[0]) ? ~~arguments[0] : this.scrollLeft, void 0 !== arguments[0].top ? ~~arguments[0].top : void 0 !== arguments[1] ? ~~arguments[1] : this.scrollTop)
                                    }
                                }, r.prototype.scrollBy = function () {
                                    void 0 !== arguments[0] && (!0 !== l(arguments[0]) ? this.scroll({
                                        left: ~~arguments[0].left + this.scrollLeft,
                                        top: ~~arguments[0].top + this.scrollTop,
                                        behavior: arguments[0].behavior
                                    }) : a.elementScroll.call(this, void 0 !== arguments[0].left ? ~~arguments[0].left + this.scrollLeft : ~~arguments[0] + this.scrollLeft, void 0 !== arguments[0].top ? ~~arguments[0].top + this.scrollTop : ~~arguments[1] + this.scrollTop))
                                }, r.prototype.scrollIntoView = function () {
                                    if (!0 !== l(arguments[0])) {
                                        var n = function (t) {
                                            for (; t !== e.body && !1 === (r = p(n = t, "Y") && h(n, "Y"), o = p(n, "X") && h(n, "X"), r || o);) t = t.parentNode || t.host;
                                            var n, r, o;
                                            return t
                                        }(this), r = n.getBoundingClientRect(), o = this.getBoundingClientRect();
                                        n !== e.body ? (f.call(this, n, n.scrollLeft + o.left - r.left, n.scrollTop + o.top - r.top), "fixed" !== t.getComputedStyle(n).position && t.scrollBy({
                                            left: r.left,
                                            top: r.top,
                                            behavior: "smooth"
                                        })) : t.scrollBy({left: o.left, top: o.top, behavior: "smooth"})
                                    } else a.scrollIntoView.call(this, void 0 === arguments[0] || arguments[0])
                                }
                            }

                            function u(t, e) {
                                this.scrollLeft = t, this.scrollTop = e
                            }

                            function l(t) {
                                if (null === t || "object" !== o(t) || void 0 === t.behavior || "auto" === t.behavior || "instant" === t.behavior) return !0;
                                if ("object" === o(t) && "smooth" === t.behavior) return !1;
                                throw new TypeError("behavior member of ScrollOptions " + t.behavior + " is not a valid value for enumeration ScrollBehavior.")
                            }

                            function p(t, e) {
                                return "Y" === e ? t.clientHeight + c < t.scrollHeight : "X" === e ? t.clientWidth + c < t.scrollWidth : void 0
                            }

                            function h(e, n) {
                                var r = t.getComputedStyle(e, null)["overflow" + n];
                                return "auto" === r || "scroll" === r
                            }

                            function d(e) {
                                var n, r, o, a, c = (s() - e.startTime) / i;
                                a = c = 1 < c ? 1 : c, n = .5 * (1 - Math.cos(Math.PI * a)), r = e.startX + (e.x - e.startX) * n, o = e.startY + (e.y - e.startY) * n, e.method.call(e.scrollable, r, o), r === e.x && o === e.y || t.requestAnimationFrame(d.bind(t, e))
                            }

                            function f(n, r, o) {
                                var i, c, l, p, h = s();
                                p = n === e.body ? (c = (i = t).scrollX || t.pageXOffset, l = t.scrollY || t.pageYOffset, a.scroll) : (c = (i = n).scrollLeft, l = n.scrollTop, u), d({
                                    scrollable: i,
                                    method: p,
                                    startTime: h,
                                    startX: c,
                                    startY: l,
                                    x: r,
                                    y: o
                                })
                            }
                        }
                    }
                }(po = {exports: {}}), po.exports).polyfill, (fo = ho = ho || {})[fo.JSERROR = 0] = "JSERROR", fo[fo.DEFAULT = 1] = "DEFAULT", (_o = vo = vo || {}).INCLUDE = "include", _o.REGEX = "regex";
                var xo = (ko.prototype.getEvents = function () {
                    return this.events
                }, ko.prototype.visibleChange = function (t) {
                    !1 === t ? (this.behaviorPost(!1), this.stopRecord()) : (this.stopRecord(), this.initRecord())
                }, ko.prototype.initRecord = function () {
                    this.checkUrlPattern(this.patterns) && (this.record = So({emit: this.emit}), this.mode === ho.DEFAULT && this.shared.emitter && this.intervalPost())
                }, ko.prototype.stopRecord = function () {
                    this.cachedEvents = p(this.events), this.events = [], this.record && (this.record(), this.record = void 0), this.intervalId && window.clearInterval(this.intervalId)
                }, ko.prototype.resetRecord = function () {
                    this.stopRecord(), this.record = So({emit: this.emit})
                }, ko.prototype.intervalPost = function () {
                    var t = this;
                    this.intervalId = window.setInterval((function () {
                        t.behaviorPost(!1), t.events = []
                    }), 2e4)
                }, ko.prototype.checkUrlPattern = function (t) {
                    if (v(t) && 0 === t.length) return !0;
                    var e = window.location.href;
                    return t.some((function (t) {
                        if (t.match_type === vo.INCLUDE) return -1 < e.indexOf(t.pattern);
                        if (t.match_type !== vo.REGEX) return !0;
                        var n = t.pattern.match(/^\/(.*?)\/([gim]*)$/);
                        return (n ? new RegExp(n[1], n[2]) : new RegExp(t.pattern)).test(e)
                    }))
                }, ko);

                function ko(t, e) {
                    var n = this;
                    this.shared = window.Slardar && window.Slardar.shared || {}, this.errorBehaviorPost = function (t) {
                        var e = [];
                        if (n.events.length < 100) {
                            var r = 0 === n.cachedEvents.length ? n.events : n.events.slice(2);
                            e = n.cachedEvents.concat(r)
                        } else e = n.events;
                        var o = {ev_type: "behavior", events: e, event_id: t};
                        n.shared.sendEvent && d(n.shared.sendEvent) && 0 < e.length && n.shared.sendEvent({
                            event: o,
                            type: "post",
                            name: "BehaviorPlugin"
                        }), n.resetRecord()
                    }, this.behaviorPost = function (t) {
                        var e = {ev_type: "behavior", events: n.events};
                        n.shared.sendEvent && d(n.shared.sendEvent) && 0 < n.events.length && n.shared.sendEvent({
                            event: e,
                            type: "post",
                            name: "BehaviorPlugin"
                        }), t && n.resetRecord()
                    }, this.urlChange = function () {
                        0 === n.patterns.length ? n.behaviorPost(!1) : n.checkUrlPattern(n.patterns) ? n.record || (n.stopRecord(), n.initRecord()) : (n.behaviorPost(!1), n.stopRecord())
                    }, this.emit = function (t) {
                        n.mode === ho.JSERROR ? (n.events.push(t), 150 < n.events.length && n.resetRecord()) : n.events.push(t)
                    }, this.mode = t, this.pluginSettings = e, this.patterns = C(this.pluginSettings, "behavior.patterns", []), this.events = [], this.intervalId = null, this.cachedEvents = []
                }

                var To, Oo, jo = window.Slardar && window.Slardar.shared || {};

                function Co(t, e) {
                    var n = C(t, e[0]), r = C(t, e[1]), o = C(t, e[2]), i = N(document.cookie, B);
                    return n && (v(o) && -1 < o.indexOf(i) || Math.random() < r)
                }

                function Ro(t) {
                    if (g() && "undefined" != typeof Set && void 0 !== Array.from && "undefined" != typeof WeakMap) {
                        if (Co(t, ["behavior.enable", "behavior.sample_rate", "behavior.slardar_web_ids"])) {
                            var e = new xo(To.DEFAULT, t);
                            e.initRecord(), (new pt).setup((function () {
                                return e.urlChange()
                            })), jo.emitter && jo.emitter.on && d(jo.emitter.on) && jo.emitter.on("visibilitychange", (function (t) {
                                return e.visibleChange(t)
                            }))
                        }
                        if (Co(t, ["sentry.behavior_enable", "sentry.behavior_sample_rate", "sentry.behavior_slardar_web_ids"])) {
                            var n = new xo(To.JSERROR, t);
                            if (n.initRecord(), jo.emitter && jo.emitter.on && d(jo.emitter.on) && jo.emitter.on("event_id", (function (t) {
                                n.errorBehaviorPost(t)
                            })), window.Slardar && window.Slardar.shared) {
                                var r = jo.plugins || {};
                                r.behavior = n, window.Slardar.shared.plugins = r
                            }
                        }
                    }
                }

                function Lo(t) {
                    var e = {};
                    jo.config && h(jo.config.plugins) && (e = jo.config.plugins), t(e)
                }

                document.addEventListener("visibilitychange", (function () {
                    jo.emitter && ("hidden" === document.visibilityState && jo.emitter.emit("visibilitychange", !1), "visible" === document.visibilityState && jo.emitter.emit("visibilitychange", !0))
                })), (Oo = To = To || {})[Oo.JSERROR = 0] = "JSERROR", Oo[Oo.DEFAULT = 1] = "DEFAULT", function (t) {
                    if ("script" === jo.installedType) return Lo(t);
                    if ("npm" === jo.installedType) {
                        if ("async" === jo.pluginsLoadType) return Lo(t);
                        jo.emitter && jo.emitter.on("pluginsReady", (function () {
                            Lo(t)
                        }))
                    }
                }(Ro);
                var Po = Ut;
                e.BehaviorMonitor = Ro, e.Sentry = Lr, e.SlardarBrowser = At, e.default = Po, Object.defineProperty(e, "__esModule", {value: !0})
            }(e)
        }).call(this, n(1167), n(58), n(4932)(t))
    }, 4932: function (t, e) {
        t.exports = function (t) {
            return t.webpackPolyfill || (t.deprecate = function () {
            }, t.paths = [], t.children || (t.children = []), Object.defineProperty(t, "loaded", {
                enumerable: !0,
                get: function () {
                    return t.l
                }
            }), Object.defineProperty(t, "id", {
                enumerable: !0, get: function () {
                    return t.i
                }
            }), t.webpackPolyfill = 1), t
        }
    }
}]);
//# sourceMappingURL=slardar.3df59f9e919761129109.js.map