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

        /* 회원 수정 */
        $("#btn-modify").on("click", () => {
            _this.modify();
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

    /* 회원 수정 */
    modify : function() {
        const data = {
            username: $('#username').val(),
            nickname: $('#nickname').val(),
            password: $('#password').val(),
            name: $('#name').val()
        };

        // 공백 및 빈 문자열 체크
        if (!data.nickname || data.nickname.trim() === "" || !data.password || data.password.trim() === "") {
            alert("공백 또는 입력하지 않은 부분이 있습니다.");
            return false;
        }
        // 유효성 검사
        else if (!/^[가-힣a-zA-Z0-9]{2,10}$/.test(data.nickname)) {
            alert("닉네임은 특수문자를 포함하지 않은 2~10자리여야 합니다.");
            $('#username').focus();
            return false;
        } else if (!/(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\W)(?=\S+$).{8,16}/.test(data.password)) {
            alert("비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.");
            $('#password').focus();
            return false;
        }

        const confirmCheck = confirm("수정하시겠습니까?");

        if (confirmCheck == true) {
            $.ajax({
                type: 'PUT',
                url: '/api/modify/'+ data.username,
                dataType: 'text',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert("회원 수정이 완료되었습니다.");
                location.href="/board/list";
            }).fail(function (error) {
                if (error.status === 500) {
                    alert("이미 사용 중인 닉네임입니다.");
                    $('#nickname').focus();
                } else {
                    alert(JSON.stringify(error));
                }
            });
        }
    }
}

index.init();