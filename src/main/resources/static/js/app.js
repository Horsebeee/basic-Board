let index = {
    init: function () {
        const _this = this;

        /* 게시물 저장 */
        $("#btn-save").on("click", () => {
            _this.save();
        });

        /* 게시물 수정 */
        $("#btn-update").on("click", () => {
            _this.update();
        });

        /* 게시물 삭제 */
        $("#btn-delete").on("click", () => {
            _this.delete();
        });

    },
    /* 게시물 저장 */
    save: function () {
        const data = {
            title: $("#title").val(),
            content: $("#content").val(),
            writer: $("#name").val()
        }
        const confirmCheck = confirm("작성하시겠습니까?");

        if(confirmCheck === true){

            /* 공백과 빈 문자열 체크 */
            if (!data.title || data.title.trim() === "" || !data.content || data.content.trim() === ""){
                alert("공백 또는 입력하지 않은 부분이 존재합니다.");
                return false;
            } else {
                $.ajax({
                    type: 'POST',
                    url: '/api/board',
                    dataType: 'text', /* restapi 에서 리턴값이 text 인지 json 인지 확인 할 것!  */
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(data)
                }).done(function(){
                    alert("등록되었습니다.");
                    location.href="/board/list";
                }).fail(function(error){
                    alert(JSON.stringify(error));
                });
            }
        }
    },
    /* 게시물 수정 */
    update : function(){
        const data = {
            board_no : $('#board_no').val(),
            title : $('#title').val(),
            content : $('#content').val(),
            view_cnt : $('#view_cnt').val()
        };

        const confirmCheck = confirm("수정하시겠습니까?");
        if(confirmCheck === true){

            /* 공백 또는 빈 문자열 확인 */
            if(!data.title || data.title.trim() === "" || !data.content || data.content.trim() === ""){
                alert("공백 또는 입력하지 않은 부분이 존재합니다.");
                return false;
            } else {
                $.ajax({
                    type: 'PUT',
                    url: '/api/update/'+data.board_no,
                    dataType: 'text',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(data)
                }).done(function() {
                    alert("수정되었습니다.");
                   location.href="/board/"+data.board_no;
                }).fail(function (error){
                    alert(JSON.stringify(error));
                });
            }
        }
    },

    /* 게시물 삭제 */
    delete : function(){
        const data = {
            board_no : $('#board_no').val(),
            // writer : $('#writer').val(),
        };

        const confirmCheck = confirm("삭제하시겠습니까?");
        if(confirmCheck === true){
            $.ajax({
                type: 'DELETE',
                url: '/api/delete/'+data.board_no,
                dataType: 'text',
                contentType: 'application/json; charset=utf-8'
            }).done(function(){
                alert("삭제되었습니다.");
                location.href="/board/list";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        }

    },
}

index.init();