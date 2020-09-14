A aplicação foi desenvolvida em Java, implementando Fragments e Activities para lidar com as transições de view.
Para efetuar requisições HTTPS foi utilizado o `Retrofit`, permitindo a criação de requisições customizadas e seguindo os padrões de objetos que são enviado e recebidos pela API.

A aplicação está dividida entre os seguintes pacotes:
`adapter`
	Neste pacote estão localizados todos os adapter utilizados para carregar os dados nos `RecyclerView`

`interfaces`
	Todas as interfaces ficam dentro desta classe

`models`
	Todos os modelos de dados ficam dentro deste pacote, como dados de contas, modelos para requisição e modelos de respostas esperados.

	`accountBalance`

Nós estamos usando algumas importantes bibliotecas/tecnologias para o desenvolvimento Android.

    Butter Knife - Para o bind de campos e métodos para as views.
    Glide - Para o carregamento de imagens nas views.
    RxAndroid - Uso de programação reativa. Padrão Observer.
    Retrofit - Client HTTP para requisições a APIs.
    
**Screenshots**
 
 ![](/screenshots/1.jpg) ![](/screenshots/2.jpg) ![](/screenshots/3.jpg) ![](/screenshots/4.jpg) ![](/screenshots/5.jpg)
