  var ws;
            function setConnected(connected) {
                $("#connect").prop("disabled", connected);
                $("#disconnect").prop("disabled", !connected);
                if (connected) {
                    $("#sendmessage").show();
                } else {
                    $("#sendmessage").hide();
                }
            }

            function connect() {
                /*<![CDATA[*/
                var url = /*[['ws://'+${#httpServletRequest.serverName}+':'+${#httpServletRequest.serverPort}+@{/web-socket}]]*/ 'ws://localhost:8001/web-socket';
                /*]]>*/
                ws = new WebSocket(url);
                ws.onopen = function () {
                    showBroadcastMessage('<div class="alert alert-success">Connected to server</div>');
                };
                ws.onmessage = function (data) {
                    showBroadcastMessage(createTextNode(data.data));
                };
                setConnected(true);
            }

            function disconnect() {
                if (ws != null) {
                    ws.close();
                    showBroadcastMessage('<div class="alert alert-warning">Disconnected from server</div>');
                }
                setConnected(false);
            }

            function send() {
                ws.send($("#message").val());
                $("#message").val("");
            }

            function createTextNode(msg) {
                return '<div class="alert alert-info">' + msg + '</div>';
            }

            function showBroadcastMessage(message) {
                $("#content").html($("#content").html() + message);
            }