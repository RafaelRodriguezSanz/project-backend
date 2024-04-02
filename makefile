build:
ifeq ($(strip $(VERSION)),)
	@echo "ERROR: Uso: make build VERSION=1.0.1"
	@exit 1
endif
	mvn clean install package -Dmaven.version.number=$(VERSION) -Dspring.profiles.active=prod

clean:
	mvn clean