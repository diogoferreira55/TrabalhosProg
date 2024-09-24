<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "scoreboard";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$nome = $_POST['nome'];
$pontuacao = $_POST['pontuacao'];
$precisao = $_POST['precisao'];
$erros = $_POST['erros'];
$circulos_nao_acertados = $_POST['circulos_nao_acertados'];
$tempo_jogado = $_POST['tempo_jogado'];
$dificuldade = $_POST['dificuldade'];

if ($tempo_jogado == 10) {
    $table_name = "tempo_10";
} elseif ($tempo_jogado == 30) {
    $table_name = "tempo_30";
} elseif ($tempo_jogado == 60) {
    $table_name = "tempo_1m";
} elseif ($tempo_jogado == 120) {
    $table_name = "tempo_2m";
}

$sql = "INSERT INTO $table_name (nome, pontuacao, precisao, erros, circulos_nao_acertados, dificuldade)
VALUES ('$nome', '$pontuacao', '$precisao', '$erros', '$circulos_nao_acertados', '$dificuldade')";

if ($conn->query($sql) === TRUE) {
    echo "Dados inseridos com sucesso!";
} else {
    echo "Erro ao inserir dados: " . $conn->error;
}

$conn->close();
?>