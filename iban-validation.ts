'use client';

export default function ibanValidation(iban: string) {
  const rawIban = iban.replace(/\s+/g, '').toUpperCase();
  if (rawIban.length < 15 || rawIban.length > 34) return false;
  if (!/^[A-Z]{2}\d{2}[A-Z0-9]+$/.test(rawIban)) return false;
  const rearranged = rawIban.slice(4) + rawIban.slice(0, 4);
  const numericIban = transferLetterToInt(rearranged);
  let remainder = numericIban;
  let block: string;
  let temp: number;

  while (remainder.length > 2) {
    block = remainder.slice(0, 9);
    temp = parseInt(block, 10) % 97;
    remainder = temp.toString() + remainder.slice(block.length);
  }

  return parseInt(remainder, 10) % 97 === 1;
}

function transferLetterToInt(str: string) {
  let res = '';

  for (let i = 0; i < str.length; i++) {
    const ch = str[i];

    if (/[A-Z]/i.test(ch)) {
      res += (ch.toUpperCase().charCodeAt(0) - 55).toString();
    } else {
      res += ch;
    }
  }
  return res;
}
