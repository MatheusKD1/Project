import os

with open('ping\Beta\localhost.bat') as file: #Diretorio do arquivo .bat com os endereços IP
    host = file.read() # Instanciando arquivo .bat a variavel  
    host = host.splitlines() # Comando para realizar leitura por linhas, evitando concatenação
    
    for ip in host: # Loop para verificar IP's no arquivo .bat
        response = os.popen('ping {}'.format(ip)).read() # Atribuindo endereço ao comando do CMD
        
        if "(0% de" in response: # Caso haja 0% de perda
            print('Endereço {} || On-line'.format(ip))
            print('=' * 40)

        elif "(100% de" in response: # Caso haja 100% de perda
            print('Endereço {} || Off-line'.format(ip))
            print('=' * 35)
        else: # Caso o endereço IP esteja oscilando
            print('Endereço {} || Oscilando'.format(ip))
            print('=' * 35)
