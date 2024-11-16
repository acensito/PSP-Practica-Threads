# EJERCICIO DE HILOS - PRACTICA 2 PSP

## ¿DE QUÉ TRATA ESTA PRACTICA?

Se trata de realizar un programa que sincronice mediante hilos las entradas/salidas a una sala de Stream de un determinado juego.

- Los jugadores pueden crear una partida pero solo podrá entrar un jugador por sala. Si ya hay un jugador dentro con una partida, el siguiente jugador tendrá que esperar a que termine.

- Los Espectadores pueden entrar todos los que se desee (opcional poner un límite de 5), pero tendrán que esperar a que se inicie una partida por un jugador, es decir solo podrán entrar a la sala si un jugador ha iniciado una partida, pudiendo durante la partida entrar y salir, incluso se pueden unir más usuarios con la partida iniciada.

- Cuando el jugador abandona la sala, automáticamente los espectadores salen de ella, dejando entrar a otro jugador si está en cola y a los usuarios nuevos que deseen entrar. **Nota:** los usuarios de la partida anterior no se quedan de forma automática para ver la siguiente, sino que si desean verla deben entrar de nuevo o hacer cola si no ha comenzado.