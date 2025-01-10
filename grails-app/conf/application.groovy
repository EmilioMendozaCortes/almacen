grails.gorm.failOnError = true
grails.gorm.autoFlush = true

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.ordenaris.almacen.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.ordenaris.almacen.UserRole'
grails.plugin.springsecurity.authority.className = 'com.ordenaris.almacen.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/user/**', access: ['ROLE_ROOT', 'ROLE_ADMIN']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern:"/api/**", filters:"JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-authenticationFilter"],
	[pattern:"/auth/**", filters:"JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter"],
	[pattern:"/admin/**", filters:"JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-authenticationFilter"],
    [pattern:"/public/**", filters:"anonymousAuthenticationFilter,restTokenValidationFilter,restExceptionTranslationFilter,filterInvocationInterceptor"]
]


grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = true //acceder aunque no esta activa la seción
grails.plugin.springsecurity.rest.token.validation.useBearerToken = true 
grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token' 
grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 86400 // tiempo de expiración
// grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 3600 // sesion de 1 hora

grails.plugin.springsecurity.rest.token.validation.active=true //seción activa
grails.plugin.springsecurity.rest.token.validation.endpointUrl='/api/validate' // ruta de laseción activa al endpoint

grails.plugin.springsecurity.rest.login.active=true //seción activa
grails.plugin.springsecurity.rest.login.useJsonCredentials = true //usar credenciales
grails.plugin.springsecurity.rest.login.failureStatusCode = 401 //rutas prohibidas
grails.plugin.springsecurity.rest.login.usernamePropertyName = 'username' //Nombre de usuario para el request del body del json
grails.plugin.springsecurity.rest.login.passwordPropertyName='password' // contraseña para el request del body del json
grails.plugin.springsecurity.rest.login.endpointUrl='/api/login' // especifica el endpint para el login
grails.plugin.springsecurity.rest.login.useRequestParamsCredentials = false  //parametros para las credenciales