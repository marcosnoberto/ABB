# Árvore Binária de Busca em Java

## Descrição Breve
Este projeto tem como objetivo implementar uma Árvore Binária de Busca (ABB), capaz de armazenar valores inteiros e suportar operações além das convencionais de busca, inserção e remoção. <br> <br>
A ABB implementada neste projeto inclui operações adicionais, como a busca do enésimo elemento, determinação da posição de um elemento em um percurso em ordem simétrica, cálculo da mediana, cálculo da média, verificação se a árvore é cheia ou completa, impressão em diferentes formatos, entre outras. Além disso, para aprimorar o desempenho, será utilizada uma abordagem de aumento da árvore, armazenando informações extras em cada nó, o que facilitará a execução eficiente dessas operações.


## Compilação e Execução
Segue abaixo as instruções para compilação e execução do programa em uma máquina com Ubuntu:
1. **Requisitos do Sistema:**
   - Certifique-se de ter o `java` instalado em sua máquina. Se não estiver instalado, utilize o seguinte comando:
     ```
     sudo apt-get install openjdk-18-jdk
     ```

2. **Compilação:**
   - Navegue até o diretório do projeto:
     ```
     cd [endereço_local]/ABB
     ```
   - Compile todos os arquivos .java do diretório e os armazene em 'bin':
     ```
     javac -d bin -cp src src/*.java
     ```

3. **Execução:**
   - Execute a classe principal do projeto:
     ```
     java -cp bin App
     ```

## Observações
- Certifique-se de ajustar **[endereço_local]** conforme necessário para refletir o local real do projeto na sua máquina.
- **Arquivos de Texto:**
  - No diretório raíz existem dois arquivos de texto. O primeiro, 'arquivo_comandos.txt', contém os valores iniciais da árvore, e o segundo, 'arquivo_entrada.txt', contém os comandos utilizados para rodar o programa.
