from faker import Faker
import json

fake = Faker()

temp = []

for _ in range(10):
    temp.append({'id': _, 'content': fake.name()})

result = {
    'greetings': temp
}

with open('greetings.json', 'w', encoding='utf-8') as f:
    json.dump(result, f)