"use client";

const swiftValidation = async (swift: string) => {
  const res: Array<string> = [];
  //   const res = await API.get(
  //     API_ENDPOINTS.GET_COUNTRIES_ISO,
  //     {},
  //     'fwwclient_commons'
  //   );
  //   console.log('API 2 code', res);
  const rawSwift = swift.replace(/\s+/g, "").toUpperCase();
  if (rawSwift.length !== 8 && rawSwift.length !== 11) return false;
  const swiftRegex = /^[A-Z]{4}[A-Z]{2}[A-Z0-9]{2}([A-Z0-9]{3})?$/;

  if (swiftRegex.test(rawSwift)) {
    const str = rawSwift.slice(4, 6);
    return isValidCountry(res, str);
  }
};

function isValidCountry(countries: any, code: string) {
  return countries.some((item: any) => item.iso_alpha_2 === code);
}

export default swiftValidation;
