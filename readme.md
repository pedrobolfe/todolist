Qual é a diferença entre autenticação e autorização? Exemplifique com o projeto.

Autenticação verifica quem é o usuário, conferindo o nome e a senha. Autorização define o que ele pode fazer. No projeto, usuario e admin podem listar e cadastrar tarefas, mas só o admin pode excluir.

Para que servem SecurityFilterChain, UserDetailsService e PasswordEncoder?

SecurityFilterChain configura a autenticação e as permissões de cada rota. UserDetailsService busca o usuário, sua senha codificada e seu perfil. No projeto, os usuários ficam em memória. PasswordEncoder codifica e verifica as senhas usando BCrypt.

Qual é a diferença entre os códigos HTTP 401 e 403?

O 401 acontece quando faltam credenciais ou elas estão erradas. O 403 acontece quando o usuário está autenticado, mas não tem permissão. Por exemplo, senha errada retorna 401, e tentar excluir uma tarefa com o perfil USER retorna 403.

Como as regras de acesso foram configuradas?

As regras foram definidas no SecurityFilterChain, por método HTTP e rota. GET em /tarefas e /tarefas/{id} e POST em /tarefas permitem USER ou ADMIN. DELETE em /tarefas/{id} permite somente ADMIN. As demais requisições são bloqueadas.

A autenticação usa HTTP Basic, com nome de usuário e senha.

O que é CSRF e como foi tratado no projeto?

CSRF é um ataque que faz o navegador de um usuário autenticado enviar uma requisição sem ele querer. No projeto, a proteção foi desativada com .csrf(AbstractHttpConfigurer::disable) para os testes da API no Postman e no curl, que enviam as credenciais diretamente. Se a API for usada por um navegador com autenticação automática, essa configuração precisa ser revista.
