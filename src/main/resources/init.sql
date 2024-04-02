CREATE SCHEMA IF NOT EXISTS conecta_foods_users;
CREATE SCHEMA IF NOT EXISTS conecta_foods_salables;
CREATE SCHEMA IF NOT EXISTS conecta_foods_budgets;
CREATE SCHEMA IF NOT EXISTS conecta_foods_discounts;
CREATE SCHEMA IF NOT EXISTS conecta_foods_payments;

CREATE TABLE IF NOT EXISTS conecta_foods_users.IMAGE (
                                                         id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
                                                         data BLOB NOT NULL
);

CREATE TABLE IF NOT EXISTS conecta_foods_discounts.ENUM_CURRENCY (
                                                                     currency VARCHAR(255) PRIMARY KEY,
                                                                     symbol VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS conecta_foods_discounts.ENUM_DISCOUNT_TYPE (
                                                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                                                          discount_type VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS conecta_foods_payments.ENUM_PAYMENT_METHOD (
                                                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                                                          payment_method_type VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS conecta_foods_users.PROVIDER (
                                                            name VARCHAR(255) NOT NULL PRIMARY KEY,
                                                            description VARCHAR(255) NOT NULL,
                                                            qualification SMALLINT CHECK (qualification >= 1 AND qualification <= 5),
                                                            profile_image_id UUID NOT NULL,
                                                            FOREIGN KEY (profile_image_id) REFERENCES conecta_foods_users.IMAGE(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_discounts.DISCOUNT (
                                                                id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
                                                                discount_amount BIGINT NOT NULL,
                                                                type_id INT NOT NULL,
                                                                FOREIGN KEY (type_id) REFERENCES conecta_foods_discounts.ENUM_DISCOUNT_TYPE(id),
                                                                UNIQUE (discount_amount, type_id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_users.BUYER_USER (
                                                              name VARCHAR(255) PRIMARY KEY,
                                                              qualification SMALLINT CHECK (qualification >= 1 AND qualification <= 5),
                                                              profile_image_id UUID NOT NULL,
                                                              FOREIGN KEY (profile_image_id) REFERENCES conecta_foods_users.IMAGE(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_salables.PRODUCT (
                                                              name VARCHAR(255) NOT NULL,
                                                              provider_name VARCHAR(255) NOT NULL,
                                                              description VARCHAR(255) NOT NULL,
                                                              unit_cost BIGINT NOT NULL,
                                                              currency VARCHAR(255) NOT NULL,
                                                              variation VARCHAR(255),
                                                              image_id UUID NOT NULL,
                                                              PRIMARY KEY (name, provider_name),
                                                              FOREIGN KEY (provider_name) REFERENCES conecta_foods_users.PROVIDER(name),
                                                              FOREIGN KEY (image_id) REFERENCES conecta_foods_users.IMAGE(id),
                                                              FOREIGN KEY (currency) REFERENCES conecta_foods_discounts.ENUM_CURRENCY(currency)
);

CREATE TABLE IF NOT EXISTS conecta_foods_salables.EVENT (
                                                            name VARCHAR(255) NOT NULL,
                                                            provider_name VARCHAR(255) NOT NULL,
                                                            description VARCHAR(255) NOT NULL,
                                                            PRIMARY KEY (name, provider_name),
                                                            FOREIGN KEY (provider_name) REFERENCES conecta_foods_users.PROVIDER(name)
);

CREATE TABLE IF NOT EXISTS conecta_foods_salables.SERVICE (
                                                              name VARCHAR(255) NOT NULL,
                                                              provider_name VARCHAR(255) NOT NULL,
                                                              description VARCHAR(255) NOT NULL,
                                                              unit_cost BIGINT NOT NULL,
                                                              currency VARCHAR(255) NOT NULL,
                                                              variation VARCHAR(255),
                                                              image_id UUID NOT NULL,
                                                              PRIMARY KEY (name, provider_name),
                                                              FOREIGN KEY (provider_name) REFERENCES conecta_foods_users.PROVIDER(name),
                                                              FOREIGN KEY (image_id) REFERENCES conecta_foods_users.IMAGE(id),
                                                              FOREIGN KEY (currency) REFERENCES conecta_foods_discounts.ENUM_CURRENCY(currency)
);

CREATE TABLE IF NOT EXISTS conecta_foods_budgets.BUDGET (
                                                            id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
                                                            creation_date TIMESTAMP NOT NULL,
                                                            provider_name VARCHAR(255) NOT NULL,
                                                            buyer_user_name VARCHAR(255) NOT NULL,
                                                            discount_id UUID,
                                                            FOREIGN KEY (provider_name) REFERENCES conecta_foods_users.PROVIDER(name),
                                                            FOREIGN KEY (buyer_user_name) REFERENCES conecta_foods_users.BUYER_USER(name),
                                                            FOREIGN KEY (discount_id) REFERENCES conecta_foods_discounts.DISCOUNT(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_budgets.BUDGET_SERVICE (
                                                                    service_name VARCHAR(255) NOT NULL,
                                                                    provider_name VARCHAR(255) NOT NULL,
                                                                    budget_id UUID NOT NULL,
                                                                    quantity INT NOT NULL,
                                                                    PRIMARY KEY (budget_id, service_name, provider_name),
                                                                    FOREIGN KEY (service_name, provider_name) REFERENCES conecta_foods_salables.SERVICE(name, provider_name),
                                                                    FOREIGN KEY (provider_name) REFERENCES conecta_foods_users.PROVIDER(name),
                                                                    FOREIGN KEY (budget_id) REFERENCES conecta_foods_budgets.BUDGET(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_budgets.BUDGET_PRODUCT (
                                                                    product_name VARCHAR(255) NOT NULL,
                                                                    provider_name VARCHAR(255) NOT NULL,
                                                                    budget_id UUID NOT NULL,
                                                                    quantity INT NOT NULL,
                                                                    PRIMARY KEY (budget_id, product_name, provider_name),
                                                                    FOREIGN KEY (product_name, provider_name) REFERENCES conecta_foods_salables.PRODUCT(name, provider_name),
                                                                    FOREIGN KEY (budget_id) REFERENCES conecta_foods_budgets.BUDGET(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_discounts.PRODUCT_DISCOUNT (
                                                                        product_name VARCHAR(255) NOT NULL,
                                                                        discount_id UUID NOT NULL,
                                                                        provider_name VARCHAR(255) NOT NULL,
                                                                        PRIMARY KEY (product_name, provider_name, discount_id),
                                                                        FOREIGN KEY (provider_name) REFERENCES conecta_foods_users.PROVIDER(name),
                                                                        FOREIGN KEY (product_name, provider_name) REFERENCES conecta_foods_salables.PRODUCT(name, provider_name),
                                                                        FOREIGN KEY (discount_id) REFERENCES conecta_foods_discounts.DISCOUNT(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_salables.agenda (
                                                             id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
                                                             date TIMESTAMP,
                                                             unit_cost BIGINT,
                                                             variation VARCHAR(255),
                                                             currency VARCHAR(255),
                                                             event_name VARCHAR(255),
                                                             provider_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS conecta_foods_discounts.SERVICE_DISCOUNT (
                                                                        service_name VARCHAR(255) NOT NULL,
                                                                        provider_name VARCHAR(255) NOT NULL,
                                                                        discount_id UUID NOT NULL,
                                                                        PRIMARY KEY (service_name, provider_name, discount_id),
                                                                        FOREIGN KEY (provider_name) REFERENCES conecta_foods_users.PROVIDER(name),
                                                                        FOREIGN KEY (service_name, provider_name) REFERENCES conecta_foods_salables.SERVICE(name, provider_name),
                                                                        FOREIGN KEY (discount_id) REFERENCES conecta_foods_discounts.DISCOUNT(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_users.CART_ITEM (
                                                             id IDENTITY PRIMARY KEY,
                                                             user_buyer_name VARCHAR(255) NOT NULL,
                                                             provider_name VARCHAR(255) NOT NULL,
                                                             agenda_id UUID NULL,
                                                             service_name VARCHAR(255) NULL,
                                                             product_name VARCHAR(255) NULL,
                                                             FOREIGN KEY (agenda_id) REFERENCES conecta_foods_salables.agenda(id),
                                                             FOREIGN KEY (service_name, provider_name) REFERENCES conecta_foods_salables.SERVICE(name, provider_name),
                                                             FOREIGN KEY (product_name, provider_name) REFERENCES conecta_foods_salables.PRODUCT(name, provider_name),
                                                             FOREIGN KEY (user_buyer_name) REFERENCES conecta_foods_users.BUYER_USER(name)
);

CREATE TABLE IF NOT EXISTS conecta_foods_budgets.BUDGET_AGENDA (
                                                                   agenda_id UUID NOT NULL,
                                                                   budget_id UUID NOT NULL,
                                                                   PRIMARY KEY (budget_id, agenda_id),
                                                                   FOREIGN KEY (agenda_id) REFERENCES conecta_foods_salables.agenda(id),
                                                                   FOREIGN KEY (budget_id) REFERENCES conecta_foods_budgets.BUDGET(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_discounts.AGENDA_DISCOUNT (
                                                                       agenda_discount_id UUID NOT NULL,
                                                                       discount_id UUID NOT NULL,
                                                                       PRIMARY KEY (agenda_discount_id, discount_id),
                                                                       FOREIGN KEY (agenda_discount_id) REFERENCES conecta_foods_salables.agenda(id),
                                                                       FOREIGN KEY (discount_id) REFERENCES conecta_foods_discounts.DISCOUNT(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_payments.RESERVATION (
                                                                  agenda_id UUID PRIMARY KEY,
                                                                  date TIMESTAMP NOT NULL,
                                                                  payment_method_id INT NOT NULL,
                                                                  FOREIGN KEY (agenda_id) REFERENCES conecta_foods_salables.agenda(id),
                                                                  FOREIGN KEY (payment_method_id) REFERENCES conecta_foods_payments.ENUM_PAYMENT_METHOD(id)
);

CREATE TABLE IF NOT EXISTS conecta_foods_users.CART (
                                                        buyer_user_name VARCHAR(255),
                                                        cart_item_id IDENTITY NOT NULL,
                                                        PRIMARY KEY (cart_item_id),
                                                        FOREIGN KEY (buyer_user_name) REFERENCES conecta_foods_users.BUYER_USER(name)
);
