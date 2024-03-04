
a) Connection Refused -> Pq o server não está ON.


e) Se tanto o cliente quanto o servidor realizarem primeiro as operações

de leitura no socket e depois as operações de escrita, é possível que ocorra

uma situação conhecida como "deadlock" (bloqueio mútuo).

O deadlock pode ocorrer quando ambas as partes estão esperando por uma

mensagem da outra parte antes de enviar uma mensagem, e nenhuma das partes

pode prosseguir até que receba uma mensagem.


f) Se tanto o cliente quanto o servidor realizarem primeiro as operações de

escrita no socket e depois as operações de leitura, pode ocorrer uma situação

conhecida como "race condition" (condição de corrida).

Na condição de corrida, a ordem em que as mensagens são enviadas e recebidas

não é previsível, o que pode levar a resultados inesperados ou incorretos.

Por exemplo, o cliente pode enviar uma mensagem antes do servidor estar

pronto para recebê-la, ou o servidor pode enviar uma mensagem antes do cliente

estar pronto para recebê-la.
