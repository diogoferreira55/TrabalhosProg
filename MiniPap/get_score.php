<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "scoreboard";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

if(isset($_GET['tabela']) && isset($_GET['dificuldade'])) {
    $tabela_escolhida = $_GET['tabela'];
    $dificuldade_escolhida = $_GET['dificuldade'];
    echo "<p id='message' style='font-size: 18px;'>Tempo escolhido: $tabela_escolhida, Dificuldade escolhida: $dificuldade_escolhida</p>";
} else {
    $tabela_escolhida = "tempo_10";
    $dificuldade_escolhida = "facil";
}

$sql = "SELECT * FROM $tabela_escolhida WHERE dificuldade = ? ORDER BY pontuacao DESC";

$stmt = $conn->prepare($sql);
if ($stmt === false) {
    echo "Erro na preparação da consulta: " . $conn->error;
    exit();
}

$stmt->bind_param("s", $dificuldade_escolhida);

$result = $stmt->execute();
if ($result === false) {
    echo "Erro na execução da consulta: " . $stmt->error;
    exit();
}

$result = $stmt->get_result();

if ($result->num_rows > 0) {
    echo "<table>";
    echo "<tr><th>Nome</th><th>Pontuação</th><th>Accuracy</th><th>Erros</th><th>Círculos não acertados</th></tr>";
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>" . $row["nome"] . "</td><td>" . $row["pontuacao"] . "</td><td>" . $row["precisao"] . "</td><td>" . $row["erros"] . "</td><td>" . $row["circulos_nao_acertados"] . "</td></tr>";
    }
    echo "</table>";
} else {
    echo "Nenhum jogador jogou com esse tempo com essa dificuldade";
}

$stmt->close();
?>