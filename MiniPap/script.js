document.addEventListener("DOMContentLoaded", function() {
    const enviarNomeBtn = document.getElementById("enviar_nome");
    const nomeInput = document.getElementById("nome_jogador");
    const startBtn = document.getElementById("start")
    const personalizarBtn = document.getElementById("personalizar")
    const corBtn = document.getElementById("cor")
    const cor1Btn = document.getElementById("verde")
    const cor2Btn = document.getElementById("amarelo")
    const cor3Btn = document.getElementById("rosa")
    const cor4Btn = document.getElementById("alterar")
    const miraBtn = document.getElementById("mira")
    const screens = document.querySelectorAll(".screen")
    const timeList = document.getElementById("time-list")
    const dificuldadeList = document.getElementById("dificuldade-list")
    const timeEl = document.getElementById("time")
    const board = document.getElementById("board")
    const tirosEl = document.getElementById("tiros")
    const cnaEl= document.getElementById("cna")
    const precisaoEl = document.getElementById("precisao")
    const acertosEl = document.getElementById("acertos")
    const pontuacaoEl = document.getElementById("pontuacao")
    const pontuacaoOver = document.getElementById("pontuacao-over")
    const tirosOver = document.getElementById("tiros-over")
    const acertosOver = document.getElementById("acertos-over")
    const cnaOver = document.getElementById("cna-over")
    const precisaoOver = document.getElementById("precisao-over")
    const restartBtns = document.querySelectorAll(".reiniciar")
    const fullScreenBtn = document.getElementById("fullscreen")
    const ModoNormalBtn = document.getElementById("normal")
    const voltarBtn = document.querySelectorAll(".voltar-voltar")
    const ModoTreinoBtn = document.getElementById("treino")
    const minimizarBtn = document.getElementById("minimizar")
    const btnMira1 = document.getElementById("btn-crossair-1")
    const btnMira2 = document.getElementById("btn-crossair-2")
    const btnMira3 = document.getElementById("btn-crossair-3")
    const btnMira4 = document.getElementById("btn-crossair-4")
    const body = document.getElementById("body");
        
    
    let time = 0,
    tempo=0,
    unlimited = false,
    dificuldade = 0,
    playing = false,
    tiros = 0,
    falhados = 0,
    precisao = 0,
    acertos = 0,
    cor=0,
    cna=0,
    interval,
    pontuacao=0,
    normal=false,
    clicado=false,
    dificuldadebd,
    playerName = ""; 
    
    enviarNomeBtn.addEventListener("click", () => {
        //alert("1");
        if (nomeInput.value.trim() !== "") {
            playerName = nomeInput.value.trim();
            screens[0].classList.add("hide");
            $('#aux_jogador').html(playerName);
        } else {
            alert("Preencha o campo");
        }
    });

    //$('#enviar_nome').click(function() {
    $('.enviar_nome_luis').click(function() {
        
        //alert("2");
        var nomeJogador = $('#nome_jogador').val();
        console.log(nomeJogador)
        localStorage.setItem('nome_jogador', nomeJogador);
        $.get("_session.php?nomeuser=" + nomeJogador, function(data, status){
            //alert("Data: " + data + "\nStatus: " + status);
            //window.location.replace("./index.html?v2");
            //$('#aux_jogador').html(nome_jogador);
            
            //window.location.reload();
        });       
    });
    
    function simulateclick() {
        var nomeJogador = $('#nome_jogador').val();
        console.log(nomeJogador)
        localStorage.setItem('nome_jogador', nomeJogador);
        $.get("_session.php?nomeuser=" + nomeJogador, function(data, status){
            //alert("Data: " + data + "\nStatus: " + status);
            window.location.replace("./index.html?v2");
        });        
    }    
    $('#reset').click(function() {
        var nomeJogador = $('#nome_jogador').val();
        console.log(nomeJogador)
        localStorage.setItem('nome_jogador', nomeJogador);
        $.get("_session.php?nomeuser=", function(data, status){
            //alert("Data: " + data + "\nStatus: " + status);
            window.location.replace("./index.html?reset=true");
        });        
    });    

    startBtn.addEventListener("click", () => {
        screens[1].classList.add("hide");
    });

    voltarBtn.forEach((btn) => {
        btn.addEventListener("click", voltar);
    });
    
    ModoNormalBtn.addEventListener("click",()=>{
        screens[2].classList.add("hide");
        screens[3].classList.add("hide");
        screens[4].classList.add("hide");
        screens[5].classList.add("hide");
        normal=true;
    })
    ModoTreinoBtn.addEventListener("click",()=>{
        screens[2].classList.add("hide");
        screens[3].classList.add("hide");
        screens[4].classList.add("hide");
        screens[5].classList.add("hide");
        screens[6].classList.add("hide");
        unlimited = true;
    })
    personalizarBtn.addEventListener("click", () => {
        screens[1].classList.add("hide");
        screens[2].classList.add("hide");
    });
    corBtn.addEventListener("click", () => {
        screens[3].classList.add("hide");
    });
    cor1Btn.addEventListener("click", () => {
        cor=1;
        screens[1].classList.remove("hide");
        screens[2].classList.remove("hide");
        screens[3].classList.remove("hide");
        screens[4].classList.remove("hide");
        screens[5].classList.remove("hide");
    });
    cor2Btn.addEventListener("click", () => {
        cor=2;
        screens[1].classList.remove("hide");
        screens[2].classList.remove("hide");
        screens[3].classList.remove("hide");
        screens[4].classList.remove("hide");
        screens[5].classList.remove("hide");
    });
    cor3Btn.addEventListener("click", () => {
        cor=3;
        screens[1].classList.remove("hide");
        screens[2].classList.remove("hide");
        screens[3].classList.remove("hide");
        screens[4].classList.remove("hide");
        screens[5].classList.remove("hide");
    });
    cor4Btn.addEventListener("click", () => {
        cor=4;
        screens[1].classList.remove("hide");
        screens[2].classList.remove("hide");
        screens[3].classList.remove("hide");
        screens[4].classList.remove("hide");
        screens[5].classList.remove("hide");
    });
    miraBtn.addEventListener("click", () => {
        screens[3].classList.add("hide");
        screens[4].classList.add("hide");
    });
    btnMira1.addEventListener("click", () => {
        screens[1].classList.remove("hide");
        screens[2].classList.remove("hide");
        screens[3].classList.remove("hide");
        screens[4].classList.remove("hide");
        screens[5].classList.remove("hide");
        body.style.cursor = "url(https://img.icons8.com/office/32/center-direction.png) 16 16, auto";
        document.querySelectorAll(".btn").forEach(btn => {
            btn.style.cursor = "url(https://img.icons8.com/office/32/center-direction.png) 16 16, auto";
        });
    });
    
    btnMira2.addEventListener("click", () => {
        screens[1].classList.remove("hide");
        screens[2].classList.remove("hide");
        screens[3].classList.remove("hide");
        screens[4].classList.remove("hide");
        screens[5].classList.remove("hide");
        body.style.cursor = "url(https://img.icons8.com/stencil/32/define-location.png) 16 16, auto";
        document.querySelectorAll(".btn").forEach(btn => {
            btn.style.cursor = "url(https://img.icons8.com/stencil/32/define-location.png) 16 16, auto";
        });
    });
    
    btnMira3.addEventListener("click", () => {
        screens[1].classList.remove("hide");
        screens[2].classList.remove("hide");
        screens[3].classList.remove("hide");
        screens[4].classList.remove("hide");
        screens[5].classList.remove("hide");
        body.style.cursor = "url(https://img.icons8.com/tiny-color/32/define-location.png) 16 16, auto";
        document.querySelectorAll(".btn").forEach(btn => {
            btn.style.cursor = "url(https://img.icons8.com/tiny-color/32/define-location.png) 16 16, auto";
        });
    });
    
    btnMira4.addEventListener("click", () => {
        screens[1].classList.remove("hide");
        screens[2].classList.remove("hide");
        screens[3].classList.remove("hide");
        screens[4].classList.remove("hide");
        screens[5].classList.remove("hide"); 
        body.style.cursor = "url(https://img.icons8.com/retro/32/center-direction.png) 16 16, auto";
        document.querySelectorAll(".btn").forEach(btn => {
            btn.style.cursor = "url(https://img.icons8.com/retro/32/center-direction.png) 16 16, auto";
        });
    });
    
    timeList.addEventListener("click", (e) => {
        if (e.target.classList.contains("time-btn")) {
            tempo = parseInt(e.target.getAttribute("data-time"));
            time = tempo;
            unlimited = e.target.hasAttribute("data-unlimited");
            screens[6].classList.add("hide");
        }
    });
    
    dificuldadeList.addEventListener("click", (e) => {
        if (e.target.classList.contains("dificuldade-btn")) {
            dificuldade = e.target.getAttribute("data-dificuldade");
        }
        if (dificuldade == 0) {
            dificuldadebd = "Facil";
        } else if (dificuldade == 1) {
            dificuldadebd = "Medio";
        } else {
            dificuldadebd = "Dificil";
        }
        screens[7].classList.add("hide");
        startGame();
    });
    
    
    function startGame() {
        screens[9].classList.add("hide");       
        playing = true;
        clicado = false;
        createRandomCircle();
        interval = setInterval(decreaseTime, 1000);
    }
    
    function decreaseTime() {
        console.log(playing);
        if (unlimited) {
            setTime("∞");
            return;
        }
        if(playing==false){
            return;
        }
        if (time == 0 && playing == true) {
            gameOver();
            return;
        }
        let current = --time;
        let miliseconds = time * 1000;
        let minutes = Math.floor(miliseconds / (1000 * 60));
        let seconds = Math.floor((miliseconds % (1000 * 60)) / 1000);
        seconds = seconds < 10 ? "0" + seconds : seconds;
        minutes = minutes < 10 ? "0" + minutes : minutes;
        console.log(minutes);
        console.log(seconds);
    
        setTime(`${minutes}:${seconds}`);
    }
    
    function voltar(){
        for(let i=7;i>0;i--){
            if(screens[i].classList.contains("hide")){
                if(i == 2){
                    screens[1].classList.remove("hide");
                    screens[2].classList.remove("hide");
                }else if(i == 3){
                    screens[3].classList.remove("hide");
                }else if(i == 4){
                    screens[3].classList.remove("hide");
                }else if(i == 5){
                    screens[2].classList.remove("hide");
                    screens[3].classList.remove("hide");
                    screens[4].classList.remove("hide");
                    screens[5].classList.remove("hide");
                }else if(i == 6 && unlimited == true){
                    screens[2].classList.remove("hide");
                    screens[3].classList.remove("hide");
                    screens[4].classList.remove("hide");
                    screens[5].classList.remove("hide");
                    screens[6].classList.remove("hide");
                }
                screens[i].classList.remove("hide");
                return;
            }
        }
    }
    function setTime(time) {
        timeEl.innerHTML = time;
    }
    
    function createRandomCircle() {
        if (playing==false) {
            return;
            circle.remove();
        }    
        const circle = document.createElement("div");
        const size = getRandomNumber(30, 100);
        const { width, height } = board.getBoundingClientRect();
        const x = getRandomNumber(0, width - size);
        const y = getRandomNumber(0, height - size);
        circle.classList.add("circle");
        circle.style.width = `${size}px`;
        circle.style.height = `${size}px`;
        circle.style.top = `${y}px`;
        circle.style.left = `${x}px`;
        
        circle.style.background = "lightblue";
        if (cor==1){
            circle.style.background = "green";
        }else if(cor==2){
            circle.style.background = "yellow";
        }else if(cor==3){
            circle.style.background = "#ff0266";
        }else if(cor == 4){
            let color= Math.floor(Math.random() *5);
            const colors=["#03DAC6","#FF0266","#b3ff00","#ccff00","#9D00FF"];
            circle.style.background = `${colors[color]}`;
        }
        board.append(circle);
        if (dificuldade == 0) {
            circle.style.animationDuration = "3s";
        } else if (dificuldade == 1) {
            circle.style.animationDuration = "2s";
        } else {
            circle.style.animationDuration = "1s";
        }
    
        circle.addEventListener("animationend", () => {
            cna++;
            cnaEl.innerHTML = cna;
            circle.remove();
            calculateAccuracy();
            if (playing) {
                createRandomCircle();
            }
        });
    }
    
    board.addEventListener("click", (e) => {
        tiros++;
        if (e.target.classList.contains("circle")) {
            acertos++;
            pontuacao+=30;
            document.getElementById("somAcerto").play();

            e.target.remove();
            createRandomCircle();
        } else {
            falhados++;
        }
        pontuacaoEl.innerHTML = pontuacao;
        tirosEl.innerHTML = tiros;
        acertosEl.innerHTML = acertos;
        calculateAccuracy();
    });
    
    function gameOver() {
        playing = false;
        clearInterval(interval);
        screens[8].classList.add("hide");
        screens[9].classList.remove("hide");
        if(normal && time == 0 && clicado==false){
            const dadosJogo = {
                nome: playerName,
                pontuacao: pontuacaoEl.innerHTML,
                precisao: precisaoEl.innerHTML,
                erros: falhados,
                circulos_nao_acertados: cnaEl.innerHTML,
                tempo_jogado: tempo,
                dificuldade: dificuldadebd,
            };
            console.log(dadosJogo);
            $.ajax({
                url: 'save_data.php',
                type: 'post',
                data: dadosJogo,
            });
        }
        tirosEl.innerHTML = 0;
        timeEl.innerHTML = 0;
        precisaoEl.innerHTML = 0;
        acertosEl.innerHTML = 0;
        cnaEl.innerHTML = 0;
        cnaOver.innerHTML = cna;
        tirosOver.innerHTML = tiros;
        acertosOver.innerHTML = acertos;
        precisaoOver.innerHTML = `${precisao}%`;
        pontuacaoOver.innerHTML = pontuacao;
    }
    
    
    function calculateAccuracy() {
        precisao = (acertos / (tiros + falhados)) * 100;
        precisao = precisao.toFixed(2);
        precisaoEl.innerHTML = `${precisao}%`;
    }
    
    function getRandomNumber(min, max) {
        return Math.round(Math.random() * (max - min) + min);
    }
    
    restartBtns.forEach((btn) => {
        btn.addEventListener("click", restartGame);
    });
    
    function restartGame() {
        for (var i = 1; i <= 9; i++) {
            screens[i].classList.remove("hide");
        }
        
        board.innerHTML = "";
    
        clearInterval(interval);
    
        clicado = true;
        unlimited = false;
        dificuldade = 0;
        tiros = 0;
        playing = false;
        falhados = 0;
        precisao = 0;
        acertos = 0;
        time = 0;
        pontuacao = 0;
        cna = 0;
        tirosEl.innerHTML = 0;
        cnaEl.innerHTML=0;
        precisaoEl.innerHTML = 0;
        pontuacaoEl.innerHTML = 0;
        acertosEl.innerHTML = 0;
        cnaEl.innerHTML = 0;
        cnaOver.innerHTML = cna;
        tirosOver.innerHTML = tiros;
        acertosOver.innerHTML = acertos;
        precisaoOver.innerHTML = `${precisao}%`;
        pontuacaoOver.innerHTML = pontuacao;
    }
    
    
    
    fullScreenBtn.addEventListener("click", fullScreen);
    let elem = document.documentElement;  
    function fullScreen() {
        if (elem.requestFullscreen) {
            elem.requestFullscreen();
        } else if (elem.mozRequestFullScreen) {
            elem.mozRequestFullScreen();
        } else if (elem.webkitRequestFullscreen) {
            elem.webkitRequestFullscreen();
        } else if (elem.msRequestFullscreen) {
            elem.msResquestFullscreen();
        }
    
        fullScreenBtn.style.display = "none";
        minimizarBtn.style.display = "block";
    }
    minimizarBtn.addEventListener("click", minimizar);
    function minimizar() {
        if (document.exitFullscreen) {
            document.exitFullscreen();
        } else if (document.mozCancelFullScreen) {
            document.mozCancelFullScreen();
        } else if (document.webkitExitFullscreen) {
            document.webkitExitFullscreen();
        } else if (document.msExitFullscreen) {
            document.msExitFullscreen();
        }
        minimizarBtn.style.display = "none";
        fullScreenBtn.style.display = "block";
    }
});